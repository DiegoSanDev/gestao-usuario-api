package br.com.devspraticar.gestao.usuario.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private boolean active;
    private String password;
    private LocalDate dateBirth;
    private LocalDateTime created;
    private LocalDateTime updated;

}
