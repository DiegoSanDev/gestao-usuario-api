package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDTO;
import br.com.devspraticar.gestaousuario.model.enums.ErrorMessageType;
import lombok.Getter;

@Getter
public class RoleNotFoundException extends RuntimeException {

    private final ErrorMessageDTO errorMessageDto;

    public RoleNotFoundException() {
        super();
        this.errorMessageDto = ErrorMessageDTO.builder()
            .message(ErrorMessageType.ROLE_NOT_FOUND.getMessage())
            .build();
    }

}