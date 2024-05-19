package br.com.devspraticar.gestao.usuario.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private boolean active;
    private String password;
    private LocalDate dateBirth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}