package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.dto.response.ErrorMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> userNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getErrorMessageDto());
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorMessageDto> emailAlreadyExistsException(EmailAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getErrorMessageDto());
    }

}