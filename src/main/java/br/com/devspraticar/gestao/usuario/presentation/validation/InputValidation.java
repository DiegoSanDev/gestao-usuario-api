package br.com.devspraticar.gestao.usuario.presentation.validation;

import br.com.devspraticar.gestao.usuario.presentation.dto.ErrorDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.ErrorFieldDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.presentation.exception.InputValidationException;
import br.com.devspraticar.gestao.usuario.model.enums.ErrorMessageType;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class InputValidation {

    private final Validator validator;

    public void validateUserRequest(UserRequestDTO user) {
        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(user);
        if (nonNull(violations) && !violations.isEmpty()) {
            throw new InputValidationException(mapViolationsToErrorDTO(violations));
        }
    }

    private ErrorDTO mapViolationsToErrorDTO(Set<ConstraintViolation<UserRequestDTO>> violations) {
        var errorDTO = new ErrorDTO();
        errorDTO.setErrors(violations.stream()
            .map(violation -> create(violation.getMessage(), violation.getPropertyPath().toString()))
            .toList());
        errorDTO.setDetail(ErrorMessageType.VALIDATION_ERROR.getDetail());
        errorDTO.setDescription(ErrorMessageType.VALIDATION_ERROR.getDescription());
        return errorDTO;
    }

    private ErrorFieldDTO create(String message, String propertyName) {
        return ErrorFieldDTO.builder()
            .message(message)
            .propertyName(propertyName)
            .build();
    }

}
