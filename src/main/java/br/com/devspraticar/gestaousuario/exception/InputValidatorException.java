package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDTO;
import lombok.Getter;

@Getter
public class InputValidatorException extends RuntimeException {

    private final transient ErrorMessageDTO errorMessageDto;

    public InputValidatorException(ErrorMessageDTO errorMessageDto) {
        this.errorMessageDto = errorMessageDto;
    }

}