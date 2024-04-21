package br.com.devspraticar.gestao.usuario.validation;

import br.com.devspraticar.gestao.usuario.rest.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.rest.exception.InputValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputValidationTest {

    @Mock
    private Validator validator;

    @Mock
    private Path path;

    @Mock
    private ConstraintViolation constraintViolation;

    @InjectMocks
    private InputValidation inputValidation;

    @BeforeEach
    public void setUp() {
        inputValidation = new InputValidation(validator);
    }

    @Test
    void testValidateUserRequest_NoViolations() {
        //Arrange
        var userRequestDTO = new UserRequestDTO();
        when(validator.validate(userRequestDTO)).thenReturn(Set.of());
        //Act - Assert
        assertDoesNotThrow(() -> inputValidation.validateUserRequest(userRequestDTO));
        verify(validator).validate(userRequestDTO);
    }

    @Test
    void testValidateUserRequest_WithViolations() {
        //Arrange
        var userRequestDTO = new UserRequestDTO();
        when(constraintViolation.getMessage()).thenReturn("O campo 'name' deve ser informado.");
        when(constraintViolation.getPropertyPath()).thenReturn(path);
        when(validator.validate(userRequestDTO)).thenReturn(Set.of(constraintViolation));
        // Act
        InputValidationException exception = assertThrows(InputValidationException.class, () -> inputValidation.validateUserRequest(userRequestDTO));
        //Assert
        verify(validator).validate(userRequestDTO);
        assertNotNull(exception.getErrorDTO());
        assertFalse(exception.getErrorDTO().getErrors().isEmpty());
        assertEquals("O campo 'name' deve ser informado.", exception.getErrorDTO().getErrors().get(0).getMessage());
    }

}
