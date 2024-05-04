package br.com.devspraticar.gestao.usuario.presentation.exception;

import br.com.devspraticar.gestao.usuario.presentation.dto.ErrorDTO;
import br.com.devspraticar.gestao.usuario.exception.BaseErrorException;
import br.com.devspraticar.gestao.usuario.exception.DuplicateEmailException;
import br.com.devspraticar.gestao.usuario.exception.MailSendException;
import br.com.devspraticar.gestao.usuario.exception.PreRegistryErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { MailSendException.class, PreRegistryErrorException.class })
    public ResponseEntity<ErrorDTO> errorException(BaseErrorException exception) {
        log.error("errorException: {}", exception.getError());
        var errorDTO = ErrorDTO.builder()
            .detail(exception.getError().getDetail())
            .description(exception.getError().getDescription())
            .build();
        return ResponseEntity.unprocessableEntity().body(errorDTO);
    }

    @ExceptionHandler(value = { DuplicateEmailException.class })
    public ResponseEntity<ErrorDTO> duplicateEmailException(DuplicateEmailException exception) {
        log.error("errorException: {}", exception.getError());
        var errorDTO = ErrorDTO.builder()
                .detail(exception.getError().getDetail())
                .description(exception.getError().getDescription())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }

    @ExceptionHandler(value = InputValidationException.class)
    public ResponseEntity<ErrorDTO> inputValidationException(InputValidationException exception) {
        log.error("InputValidationException: {}", exception.getErrorDTO());
        return ResponseEntity.unprocessableEntity().body(exception.getErrorDTO());
    }

}