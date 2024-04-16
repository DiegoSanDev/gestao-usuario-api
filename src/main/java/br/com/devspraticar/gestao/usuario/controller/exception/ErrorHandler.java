package br.com.devspraticar.gestao.usuario.controller.exception;

import br.com.devspraticar.gestao.usuario.controller.dto.ErrorDTO;
import br.com.devspraticar.gestao.usuario.exception.BaseErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BaseErrorException.class)
    public ResponseEntity<ErrorDTO> errorBaseException(BaseErrorException exception) {
        var error = exception.getError();
        var errorDTO = ErrorDTO.builder()
            .detail(error.getDetail())
            .description(error.getDescription())
            .build();
        return ResponseEntity.status(error.getHttpStatus()).body(errorDTO);
    }

    @ExceptionHandler(value = InputValidationException.class)
    public ResponseEntity<ErrorDTO> inputValidationException(InputValidationException exception) {
        log.error("InputValidationException: {}", exception.getErrorDTO());
        return ResponseEntity.unprocessableEntity().body(exception.getErrorDTO());
    }

}