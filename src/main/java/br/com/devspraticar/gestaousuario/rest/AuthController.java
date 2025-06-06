package br.com.devspraticar.gestaousuario.rest;

import br.com.devspraticar.gestaousuario.dto.request.AuthRequestDTO;
import br.com.devspraticar.gestaousuario.entity.User;
import br.com.devspraticar.gestaousuario.rest.api.AuthApi;
import br.com.devspraticar.gestaousuario.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public ResponseEntity<Map<String, String>> authenticate(AuthRequestDTO loginRequest) {
        User user = User.builder()
            .email(loginRequest.email())
            .password(loginRequest.password())
            .build();
        return ResponseEntity.ok(Map.of("access_token", authService.authenticate(user)));
    }

}