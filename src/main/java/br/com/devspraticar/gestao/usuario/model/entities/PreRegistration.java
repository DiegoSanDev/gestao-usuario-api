package br.com.devspraticar.gestao.usuario.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("pre_registration")
public class PreRegistration {

    @Id
    private Long id;
    private Long userId;
    private boolean active;
    private UUID activationKey;
    private LocalDate expirationDate;

}
