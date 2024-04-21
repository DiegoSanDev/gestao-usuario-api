package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.model.Error;
import lombok.Getter;

public abstract class BaseErrorException extends RuntimeException {

    @Getter
    private final Error error;

    protected BaseErrorException() {
        this.error = create();
    }

    protected abstract Error create();

}
