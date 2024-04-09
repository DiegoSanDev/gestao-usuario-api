package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.models.Error;
import lombok.Getter;

public abstract class ErrorBaseException extends RuntimeException {

    @Getter
    private final Error error;

    public ErrorBaseException() {
        this.error = create();
    }

    public abstract Error create();

}
