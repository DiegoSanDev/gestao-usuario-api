package br.com.devspraticar.gestaousuario.validator;

import br.com.devspraticar.gestaousuario.dto.request.UserRequestDto;
import br.com.devspraticar.gestaousuario.exception.InputValidatorException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserRequestInputValidation implements InputValidation<UserRequestDto> {

    private final Validator validator;

    @Override
    public void validate(UserRequestDto userRequestDto) {
        Set<ConstraintViolation<UserRequestDto>> violations = validator.validate(userRequestDto);
        if(!violations.isEmpty()) {
            throw new InputValidatorException(toMessageError(violations));
        }
    }

}