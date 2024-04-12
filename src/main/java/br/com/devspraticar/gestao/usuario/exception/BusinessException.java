package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.model.Error;
import lombok.Getter;

import java.io.Serializable;

@Getter
public abstract class BusinessException extends RuntimeException implements Serializable {

    private final transient Error error;

    protected BusinessException() {
        this.error = create();
    }

    public abstract Error create();

}
