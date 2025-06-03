package br.com.devspraticar.gestaousuario.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponseDto(Long id, String name, String email) {}
