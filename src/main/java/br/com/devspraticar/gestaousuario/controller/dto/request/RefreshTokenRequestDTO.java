package br.com.devspraticar.gestaousuario.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record RefreshTokenRequestDTO(
    @Schema(
        description = "Refresh token válido",
        example = "b3f2e9c1-8f7c-4c5d-b3c6-0a9e0f1e1234",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Refresh token é obrigatório")
    String refreshToken
) {}
