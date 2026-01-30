package br.com.devspraticar.gestaousuario.controller.validator;

import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDTO;
import br.com.devspraticar.gestaousuario.controller.dto.response.ViolationDTO;
import br.com.devspraticar.gestaousuario.exception.InputValidatorException;
import br.com.devspraticar.gestaousuario.model.enums.ErrorMessageType;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class InputValidation {

    private final Validator validator;

    public <T> void validate(T request) {
        Set<ConstraintViolation<T>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            throw new InputValidatorException(toMessageError(violations));
        }
    }

    private <T> ErrorMessageDTO toMessageError(Set<ConstraintViolation<T>> violations) {
        var errorMessageDto = new ErrorMessageDTO();
        errorMessageDto.setMessage(ErrorMessageType.INPUT_FIELDS_VALIDATION_ERROR.getMessage());
        errorMessageDto.setViolations(violations.stream()
            .map(violation -> create(violation.getPropertyPath().toString(), violation.getMessage()))
            .toList());
        return errorMessageDto;
    }

    private ViolationDTO create(String field, String message) {
        return ViolationDTO.builder()
            .field(field)
            .message(message)
            .build();
    }
}
