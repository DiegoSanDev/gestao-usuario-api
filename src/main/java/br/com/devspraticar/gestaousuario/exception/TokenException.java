package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.model.enums.TokenErrorType;
import lombok.Getter;

@Getter
public class TokenException extends RuntimeException{

    private final TokenErrorType tokenErrorType;

    public TokenException(TokenErrorType tokenErrorType, String msg) {
        super(msg);
        this.tokenErrorType = tokenErrorType;
    }

}
