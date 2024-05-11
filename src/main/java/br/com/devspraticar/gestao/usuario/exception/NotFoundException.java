package br.com.devspraticar.gestao.usuario.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String detail;
    private final String description;

    public NotFoundException(String detail, String description) {
        this.detail = detail;
        this.description = description;
    }

}
