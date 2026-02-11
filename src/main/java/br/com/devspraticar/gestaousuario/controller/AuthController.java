package br.com.devspraticar.gestaousuario.controller;

import br.com.devspraticar.gestaousuario.controller.api.AuthApi;
import br.com.devspraticar.gestaousuario.controller.dto.request.AuthRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.request.RefreshTokenRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.response.AuthTokenResponseDTO;
import br.com.devspraticar.gestaousuario.controller.validator.InputValidation;
import br.com.devspraticar.gestaousuario.mapper.AuthMapper;
import br.com.devspraticar.gestaousuario.model.service.RefreshTokenService;
import br.com.devspraticar.gestaousuario.security.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final InputValidation inputValidation;

    @Override
    @PostMapping("/login")
    public ResponseEntity<AuthTokenResponseDTO> authenticate(AuthRequestDTO loginRequest) {
        inputValidation.validate(loginRequest);
        var authToken = authService.authenticate(loginRequest.email(), loginRequest.password());
        var responseDTO = AuthMapper.toResponse(authToken);
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    @PostMapping("/refresh")
    public ResponseEntity<AuthTokenResponseDTO> refreshToken(RefreshTokenRequestDTO request) {
        inputValidation.validate(request);
        var authToken = refreshTokenService.refreshToken(request.refreshToken());
        var responseDTO = AuthMapper.toResponse(authToken);
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(RefreshTokenRequestDTO request) {
        inputValidation.validate(request);
        refreshTokenService.logout(request.refreshToken());
        return ResponseEntity.noContent().build();
    }
}