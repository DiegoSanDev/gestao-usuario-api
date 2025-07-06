package br.com.devspraticar.gestaousuario.security.service;

import br.com.devspraticar.gestaousuario.entity.User;
import br.com.devspraticar.gestaousuario.model.AuthToken;
import br.com.devspraticar.gestaousuario.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    public AuthToken authenticate(User user) {
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        var token = tokenProvider.generateToken(authentication);

        return AuthToken.builder()
            .accessToken(token)
            .tokenType("Bearer")
            .expiresIn(tokenProvider.getJwtExpirationMs())
            .build();
    }

}