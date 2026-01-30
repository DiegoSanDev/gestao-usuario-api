package br.com.devspraticar.gestaousuario.controller;

import br.com.devspraticar.gestaousuario.controller.dto.request.AuthRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.response.AuthTokenResponseDTO;
import br.com.devspraticar.gestaousuario.controller.validator.InputValidation;
import br.com.devspraticar.gestaousuario.model.entity.User;
import br.com.devspraticar.gestaousuario.controller.api.AuthApi;
import br.com.devspraticar.gestaousuario.security.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;
    private final InputValidation inputValidation;

    @Override
    public ResponseEntity<AuthTokenResponseDTO> authenticate(AuthRequestDTO loginRequest) {
        inputValidation.validate(loginRequest);
        var user = User.builder()
            .email(loginRequest.email())
            .password(loginRequest.password())
            .build();
        var response = authService.authenticate(user);
        var responseDto = AuthTokenResponseDTO.builder()
            .accessToken(response.getAccessToken())
            .expiresIn(response.getExpiresIn())
            .tokenType(response.getTokenType())
            .build();
        return ResponseEntity.ok(responseDto);
    }

}