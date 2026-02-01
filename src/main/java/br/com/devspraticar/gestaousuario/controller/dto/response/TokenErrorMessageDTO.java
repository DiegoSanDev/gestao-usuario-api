package br.com.devspraticar.gestaousuario.controller.dto.response;

import lombok.Builder;

@Builder
public record TokenErrorMessageDTO(
    String error,
    String message
) { }

