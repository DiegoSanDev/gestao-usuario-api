package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.dto.response.ErrorMessageDto;
import lombok.Getter;

@Getter
public class InputValidatorException extends RuntimeException {

    private final transient ErrorMessageDto errorMessageDto;

    public InputValidatorException(ErrorMessageDto errorMessageDto) {
        this.errorMessageDto = errorMessageDto;
    }

}