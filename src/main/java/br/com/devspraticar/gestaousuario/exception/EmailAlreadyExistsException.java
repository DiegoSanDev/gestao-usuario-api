package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDTO;
import br.com.devspraticar.gestaousuario.model.enums.ErrorMessageType;
import lombok.Getter;

@Getter
public class EmailAlreadyExistsException extends RuntimeException {

    private final ErrorMessageDTO errorMessageDto;

    public EmailAlreadyExistsException(String email) {
        super();
        this.errorMessageDto = ErrorMessageDTO.builder()
            .message(String.format(ErrorMessageType.USER_EMAIL_ALREADY_IN_USE.getMessage(), email))
            .build();
    }

}