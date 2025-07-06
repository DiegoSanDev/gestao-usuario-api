package br.com.devspraticar.gestaousuario.dto.response;

import lombok.Builder;

@Builder
public record AuthTokenResponseDto(
    String accessToken,
    String tokenType,
    Long expiresIn) { }
