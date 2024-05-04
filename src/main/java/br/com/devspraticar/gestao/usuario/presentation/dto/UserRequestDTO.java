package br.com.devspraticar.gestao.usuario.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO implements Serializable {

    @NotBlank(message = "O campo 'name' deve ser informado.")
    private String name;

    @NotBlank(message = "O campo 'email' deve ser informado.")
    @Email(message = "O endereço de email fornecido não está em um formato válido.")
    private String email;

    @NotBlank(message = "O campo 'password' deve ser informado.")
    private String password;

    private LocalDate dateBirth;

}
