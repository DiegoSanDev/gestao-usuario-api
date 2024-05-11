package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.domain.model.Error;
import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class BaseErrorException extends RuntimeException implements Serializable {

    private final Error error;

    protected BaseErrorException() {
        this.error = create();
    }

    protected abstract Error create();

}
