package br.com.devspraticar.gestaousuario.exception;

import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> userNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getErrorMessageDto());
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorMessageDTO> emailAlreadyExistsException(EmailAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getErrorMessageDto());
    }

    @ExceptionHandler(InputValidatorException.class)
    public ResponseEntity<ErrorMessageDTO> inputValidatorException(InputValidatorException exception) {
        log.error("{}", exception.getErrorMessageDto());
        return ResponseEntity.badRequest().body(exception.getErrorMessageDto());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorMessageDTO> genericsError(InternalServerErrorException exception) {
        log.error("{}", exception.getErrorMessageDto());
        return ResponseEntity.internalServerError().body(exception.getErrorMessageDto());
    }

}