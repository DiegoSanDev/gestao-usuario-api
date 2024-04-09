package br.com.devspraticar.gestao.usuario.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }

}
