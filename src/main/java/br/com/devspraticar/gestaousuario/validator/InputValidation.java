package br.com.devspraticar.gestaousuario.validator;

import br.com.devspraticar.gestaousuario.dto.response.ErrorMessageDto;
import br.com.devspraticar.gestaousuario.dto.response.ViolationDto;
import br.com.devspraticar.gestaousuario.enums.ErrorMessageType;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface InputValidation<T> {

    void validate(T t);

    default ErrorMessageDto toMessageError(Set<ConstraintViolation<T>> violations) {
        var errorMessageDto = new ErrorMessageDto();
        errorMessageDto.setMessage(ErrorMessageType.USER_VALIDATION_ERROR.getMessage());
        errorMessageDto.setViolations(violations.stream()
                .map(violacao -> create(violacao.getPropertyPath().toString(), violacao.getMessage()))
                .toList());
        return errorMessageDto;
    }

    private ViolationDto create(String field, String message) {
        return ViolationDto.builder()
            .field(field)
            .message(message)
            .build();
    }

}