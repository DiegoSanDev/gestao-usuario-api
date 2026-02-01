package br.com.devspraticar.gestaousuario.security.auth;

import br.com.devspraticar.gestaousuario.model.entity.RefreshToken;
import br.com.devspraticar.gestaousuario.model.entity.User;
import br.com.devspraticar.gestaousuario.model.AuthToken;
import br.com.devspraticar.gestaousuario.model.service.RefreshTokenService;
import br.com.devspraticar.gestaousuario.security.jwt.JwtTokenProvider;
import br.com.devspraticar.gestaousuario.security.model.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;
    private final JwtTokenProvider tokenProvider;

    public AuthToken authenticate(String email, String password) {
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(email, password));
        UserSecurity userSecurity = (UserSecurity) authentication.getPrincipal();
        User user = userSecurity.getUser();
        String token = tokenProvider.generateToken(authentication);
        RefreshToken refreshToken = refreshTokenService.create(user);
        return AuthToken.builder()
            .accessToken(token)
            .refreshToken(refreshToken.getToken())
            .tokenType("Bearer")
            .expiresIn(tokenProvider.getJwtExpirationMs())
            .build();
    }

}