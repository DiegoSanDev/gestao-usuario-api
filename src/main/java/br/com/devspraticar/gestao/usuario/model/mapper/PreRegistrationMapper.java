package br.com.devspraticar.gestao.usuario.model.mapper;

import br.com.devspraticar.gestao.usuario.model.entities.PreRegistration;
import br.com.devspraticar.gestao.usuario.presentation.dto.PreRegistrationDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PreRegistrationMapper {

    public PreRegistrationDTO toResponse(PreRegistration preRegistration) {
        return PreRegistrationDTO.builder()
            .active(preRegistration.isActive())
            .activationKey(preRegistration.getActivationKey())
            .expirationDate(preRegistration.getExpirationDate())
            .build();
    }

}
