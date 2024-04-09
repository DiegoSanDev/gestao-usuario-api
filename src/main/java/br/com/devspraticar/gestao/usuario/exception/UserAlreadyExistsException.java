package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.models.Error;
import org.springframework.http.HttpStatus;

import static br.com.devspraticar.gestao.usuario.enums.ErrorMessageType.DUPLICATE_EMAIL;

public class UserAlreadyExistsException extends ErrorBaseException {

    @Override
    public Error create() {
        return Error.builder()
            .detail(DUPLICATE_EMAIL.getDetail())
            .httpStatuCode(HttpStatus.CONFLICT.value())
            .description(DUPLICATE_EMAIL.getDescription())
            .build();
    }

}
