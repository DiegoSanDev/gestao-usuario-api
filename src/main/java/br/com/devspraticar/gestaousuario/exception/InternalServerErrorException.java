package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDto;
import br.com.devspraticar.gestaousuario.model.enums.ErrorMessageType;
import lombok.Getter;

@Getter
public class InternalServerErrorException extends RuntimeException {

    private final ErrorMessageDto errorMessageDto;

    public InternalServerErrorException() {
        super();
        this.errorMessageDto = ErrorMessageDto.builder()
            .message(ErrorMessageType.GENERICS_ERROR.getMessage())
            .build();
    }

}