package br.com.devspraticar.gestaousuario.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponseDTO(
    Long id,
    String name,
    String email,
    LocalDateTime createdAt,
    LocalDateTime updateAt) {}
