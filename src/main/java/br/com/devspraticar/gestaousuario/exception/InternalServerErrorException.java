package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDTO;
import br.com.devspraticar.gestaousuario.model.enums.ErrorMessageType;
import lombok.Getter;

@Getter
public class InternalServerErrorException extends RuntimeException {

    private final ErrorMessageDTO errorMessageDto;

    public InternalServerErrorException() {
        super();
        this.errorMessageDto = ErrorMessageDTO.builder()
            .message(ErrorMessageType.GENERICS_ERROR.getMessage())
            .build();
    }

}