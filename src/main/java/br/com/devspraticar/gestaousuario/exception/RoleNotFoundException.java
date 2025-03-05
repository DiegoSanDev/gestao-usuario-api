package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.dto.response.ErrorMessageDto;
import br.com.devspraticar.gestaousuario.enums.ErrorMessageType;
import lombok.Getter;

@Getter
public class RoleNotFoundException extends RuntimeException {

    private final ErrorMessageDto errorMessageDto;

    public RoleNotFoundException() {
        super();
        this.errorMessageDto = ErrorMessageDto.builder()
            .message(ErrorMessageType.ROLE_NOT_FOUND.getMessage())
            .build();
    }

}