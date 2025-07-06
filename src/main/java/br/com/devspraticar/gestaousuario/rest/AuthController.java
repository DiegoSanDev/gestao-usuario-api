package br.com.devspraticar.gestaousuario.rest;

import br.com.devspraticar.gestaousuario.dto.request.AuthRequestDTO;
import br.com.devspraticar.gestaousuario.dto.response.AuthTokenResponseDto;
import br.com.devspraticar.gestaousuario.entity.User;
import br.com.devspraticar.gestaousuario.rest.api.AuthApi;
import br.com.devspraticar.gestaousuario.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public ResponseEntity<AuthTokenResponseDto> authenticate(AuthRequestDTO loginRequest) {
        var user = User.builder()
            .email(loginRequest.email())
            .password(loginRequest.password())
            .build();
        var response = authService.authenticate(user);
        var responseDto = AuthTokenResponseDto.builder()
            .accessToken(response.getAccessToken())
            .expiresIn(response.getExpiresIn())
            .tokenType(response.getTokenType())
            .build();
        return ResponseEntity.ok(responseDto);
    }

}