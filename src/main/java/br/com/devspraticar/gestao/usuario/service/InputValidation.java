package br.com.devspraticar.gestao.usuario.service;

import br.com.devspraticar.gestao.usuario.controller.dto.ErrorDTO;
import br.com.devspraticar.gestao.usuario.controller.dto.ErrorFieldDTO;
import br.com.devspraticar.gestao.usuario.controller.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.controller.exception.InputValidationException;
import br.com.devspraticar.gestao.usuario.enums.ErrorMessageType;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class InputValidation {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validateUserRequest(UserRequestDTO user) {
        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(user);
        if (violations != null && !violations.isEmpty()) {
            throw new InputValidationException(mapViolationsToErrorDTO(violations));
        }
    }

    private ErrorDTO mapViolationsToErrorDTO(Set<ConstraintViolation<UserRequestDTO>> violations) {
        ErrorDTO errorDTO = new ErrorDTO();
        List<ErrorFieldDTO> errors = new ArrayList<>();
        violations.forEach(violation -> {
            violation.getMessage();
            var error = ErrorFieldDTO.builder()
                .message(violation.getMessage())
                .propertyName(violation.getPropertyPath().toString())
                .build();
            errors.add(error);
        });
        errorDTO.setErrors(errors);
        errorDTO.setDetail(ErrorMessageType.VALIDATION_ERROR.getDetail());
        errorDTO.setDescription(ErrorMessageType.VALIDATION_ERROR.getDescription());
        return errorDTO;
    }

}
