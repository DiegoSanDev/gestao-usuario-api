package br.com.devspraticar.gestao.usuario.validation;

import br.com.devspraticar.gestao.usuario.controller.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.controller.exception.InputValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputValidationTest {

    @Mock
    private Validator validator;

    @InjectMocks
    private InputValidation inputValidation;

    @BeforeEach
    public void setUp() {
        inputValidation = new InputValidation(validator);
    }

    @Test
    void testValidateUserRequest_NoViolations() {
        // Mock input data
        UserRequestDTO userRequestDTO = new UserRequestDTO();

        // Mock validation
        when(validator.validate(userRequestDTO)).thenReturn(Set.of());

        // Perform the test
        assertDoesNotThrow(() -> inputValidation.validateUserRequest(userRequestDTO));

        // Verify interactions
        verify(validator).validate(userRequestDTO);
    }

    @Test
    void testValidateUserRequest_WithViolations() {
        // Mock input data
        UserRequestDTO userRequestDTO = new UserRequestDTO();

        // Mock violation
        ConstraintViolation violation = mock(ConstraintViolation.class);
        when(violation.getMessage()).thenReturn("O campo 'name' deve ser informado.");
        when(violation.getPropertyPath().toString()).thenReturn("name");

        // Mock validation
        when(validator.validate(userRequestDTO)).thenReturn(Set.of(violation));

        // Perform the test
        InputValidationException exception = assertThrows(InputValidationException.class, () -> inputValidation.validateUserRequest(userRequestDTO));

        // Verify interactions
        verify(validator).validate(userRequestDTO);

        // Assert the exception message
        assertNotNull(exception.getErrorDTO());
        assertFalse(exception.getErrorDTO().getErrors().isEmpty());
        assertEquals("O campo 'name' deve ser informado.", exception.getErrorDTO().getErrors().get(0).getMessage());
    }


}
