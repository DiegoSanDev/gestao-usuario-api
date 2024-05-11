package br.com.devspraticar.gestao.usuario.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreRegistrationDTO {

    private boolean active;
    private UUID activationKey;
    private LocalDateTime expirationDate;

}
