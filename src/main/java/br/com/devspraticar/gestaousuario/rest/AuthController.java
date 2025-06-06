package br.com.devspraticar.gestaousuario.rest;

import br.com.devspraticar.gestaousuario.dto.request.AuthRequestDTO;
import br.com.devspraticar.gestaousuario.rest.api.AuthApi;
import br.com.devspraticar.gestaousuario.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Override
    public ResponseEntity<Map<String, String>> authenticate(AuthRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
        );

        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(Map.of("token", token));
    }

}
