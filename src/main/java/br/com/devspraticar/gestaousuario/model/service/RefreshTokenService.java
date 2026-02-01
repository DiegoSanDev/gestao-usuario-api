package br.com.devspraticar.gestaousuario.model.service;

import br.com.devspraticar.gestaousuario.exception.TokenException;
import br.com.devspraticar.gestaousuario.model.AuthToken;
import br.com.devspraticar.gestaousuario.model.entity.RefreshToken;
import br.com.devspraticar.gestaousuario.model.entity.User;
import br.com.devspraticar.gestaousuario.model.enums.TokenErrorType;
import br.com.devspraticar.gestaousuario.repository.RefreshTokenRepository;
import br.com.devspraticar.gestaousuario.security.auth.AuthService;
import br.com.devspraticar.gestaousuario.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${security.jwt.refreshExpirationMS}")
    private long refreshExpirationMS;

    public RefreshToken create(User user) {
        RefreshToken refreshToken = RefreshToken.builder()
            .token(UUID.randomUUID().toString())
            .user(user)
            .expiryDate(Instant.now().plusMillis(refreshExpirationMS))
            .revoked(false)
            .build();

        return refreshTokenRepository.save(refreshToken);
    }

    @Transactional
    public AuthToken refreshToken(String refreshTokenValue) {
        RefreshToken oldToken = validate(refreshTokenValue);
        User user = oldToken.getUser();
        revoke(oldToken);
        RefreshToken newRefreshToken = create(user);

        String accessToken = jwtTokenProvider.generateTokenFromUser(user);

        return AuthToken.builder()
            .accessToken(accessToken)
            .refreshToken(newRefreshToken.getToken())
            .tokenType("Bearer")
            .expiresIn(jwtTokenProvider.getJwtExpirationMs())
            .build();
    }

    public void revoke(RefreshToken token) {
        token.setRevoked(true);
        refreshTokenRepository.save(token);
    }

    private RefreshToken validate(String token) {
        RefreshToken refreshToken = refreshTokenRepository
            .findByToken(token)
            .orElseThrow(() -> new TokenException(TokenErrorType.INVALID, "Refresh token inválido"));

        if (refreshToken.isRevoked()) {
            throw new TokenException(TokenErrorType.REVOKED, "Refresh token revogado");
        }

        if (refreshToken.getExpiryDate().isBefore(Instant.now())) {
            throw new TokenException(TokenErrorType.EXPIRED, "Refresh token expirado");
        }

        return refreshToken;
    }

}