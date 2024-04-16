package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.model.Error;
import org.springframework.http.HttpStatus;

import static br.com.devspraticar.gestao.usuario.enums.ErrorMessageType.DUPLICATE_EMAIL;

public class UserAlreadyExistsException extends BaseErrorException {

    @Override
    public Error create() {
        return Error.builder()
            .httpStatus(HttpStatus.CONFLICT)
            .detail(DUPLICATE_EMAIL.getDetail())
            .description(DUPLICATE_EMAIL.getDescription())
            .build();
    }

}
