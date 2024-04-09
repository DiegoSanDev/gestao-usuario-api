package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ErrorBaseException.class)
    public ResponseEntity<Error> errorBaseException(ErrorBaseException exception) {
        var error = exception.getError();
        return ResponseEntity.status(HttpStatus.valueOf(error.getHttpStatuCode())).body(error);
    }

}