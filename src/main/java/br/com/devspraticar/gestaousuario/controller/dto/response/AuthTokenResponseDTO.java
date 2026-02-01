package br.com.devspraticar.gestaousuario.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record AuthTokenResponseDTO(
    @Schema(
        description = "Token JWT de acesso",
        example = "eyJhbGciOiJIUzUxMiJ9..."
    )
    String accessToken,

    @Schema(
        description = "Refresh token para renovação do access token",
        example = "d2a4c9e2-91e3-4b9d-9b72-7c2e8f1b5678"
    )
    String refreshToken,

    @Schema(
        description = "Tipo do token",
        example = "Bearer"
    )
    String tokenType,

    @Schema(
        description = "Tempo de expiração do access token (em segundos)",
        example = "900"
    )
    Long expiresIn
) { }
