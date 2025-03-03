package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.dto.response.ErrorMessageDto;
import br.com.devspraticar.gestaousuario.enums.ErrorMessageType;
import lombok.Getter;

@Getter
public class EmailAlreadyExistsException extends RuntimeException {

    private final ErrorMessageDto errorMessageDto;

    public EmailAlreadyExistsException(String email) {
        super();
        this.errorMessageDto = ErrorMessageDto.builder()
            .message(String.format(ErrorMessageType.USER_EMAIL_ALREADY_IN_USE.getMessage(), email))
            .build();
    }

}