package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDto;
import br.com.devspraticar.gestaousuario.model.enums.ErrorMessageType;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {

    private final ErrorMessageDto errorMessageDto;

    public UserNotFoundException() {
        super();
        this.errorMessageDto = ErrorMessageDto.builder()
            .message(ErrorMessageType.USER_NOT_FOUND.getMessage())
            .build();
    }

}