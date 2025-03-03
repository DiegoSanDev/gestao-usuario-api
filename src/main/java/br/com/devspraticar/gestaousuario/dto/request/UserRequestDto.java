package br.com.devspraticar.gestaousuario.dto.request;

import lombok.Builder;

@Builder
public record UserRequestDto(String name, String email, String password) {}
