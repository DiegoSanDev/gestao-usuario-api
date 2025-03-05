package br.com.devspraticar.gestaousuario.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
@Builder
public record UserRequestDto(
        @NotBlank(message = "O campo 'name' é obrigatório.")
        String name,

        @NotBlank(message = "O campo 'email' é obrigatório.")
        String email,

        @NotBlank(message = "O campo 'password' é obrigatório.")
        @Size(min = 6, max = 8, message = "O campo 'password' deve ter entre 6 e 8 caracteres.")
        String password,

        @NotBlank(message = "O campo 'tipoUsuario' é obrigatório.")
        @Pattern(regexp = "^(USUARIO|MODERADOR|ADMINISTRADOR)$", message = "O campo 'tipoUsuario' deve ser 'USUARIO', 'MODERADOR' ou 'ADMINISTRADOR'.")
        String userType) {}

