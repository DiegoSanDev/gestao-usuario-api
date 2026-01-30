package br.com.devspraticar.gestaousuario.controller.dto.response;

import lombok.Builder;

@Builder
public record AuthTokenResponseDTO(
    String accessToken,
    String tokenType,
    Long expiresIn) { }
