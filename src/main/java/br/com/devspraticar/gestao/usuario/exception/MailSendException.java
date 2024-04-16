package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.model.Error;
import org.springframework.http.HttpStatus;

import static br.com.devspraticar.gestao.usuario.enums.ErrorMessageType.ERROR_SEND_EMAIL;

public class MailSendException extends BaseErrorException {

    @Override
    public Error create() {
        return Error.builder()
            .httpStatus(HttpStatus.UNPROCESSABLE_ENTITY)
            .detail(ERROR_SEND_EMAIL.getDetail())
            .description(ERROR_SEND_EMAIL.getDescription())
            .build();
    }

}
