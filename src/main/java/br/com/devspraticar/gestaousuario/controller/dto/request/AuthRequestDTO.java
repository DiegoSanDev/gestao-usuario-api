package br.com.devspraticar.gestaousuario.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequestDTO(
    @Schema(
        description = "E-mail do usuário",
        example = "usuario@dominio.com",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    String email,

    @Schema(
        description = "Senha do usuário",
        example = "SenhaForte123!",
        minLength = 8,
        maxLength = 72,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "O campo 'password' é obrigatório.")
    @Size(min = 8, max = 72, message = "O campo 'password' deve ter entre 8 e 72 caracteres.")
    String password
) { }
