package br.com.devspraticar.gestao.usuario.controller;

import br.com.devspraticar.gestao.usuario.MockUtils;
import br.com.devspraticar.gestao.usuario.presentation.controller.UserController;
import br.com.devspraticar.gestao.usuario.presentation.dto.PreRegistrationDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserResponseDTO;
import br.com.devspraticar.gestao.usuario.model.service.UserService;
import br.com.devspraticar.gestao.usuario.presentation.validation.InputValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private InputValidation inputValidation;

    @InjectMocks
    private UserController userController;

    @Test
    void shouldCreatePreRegistry_Success() {
        // Arrange
        var requestDTO = new UserRequestDTO();
        var user = MockUtils.getPreRegistrationMock();
        var expectedResponseDTO = new UserResponseDTO();
        expectedResponseDTO.setId(user.getId());
        doNothing().when(inputValidation).validateUserRequest(requestDTO);
        when(userService.createPreRegistry(ArgumentMatchers.any())).thenReturn(user);
        //Act
        ResponseEntity<PreRegistrationDTO> response = userController.createPreRegistry(requestDTO);
        //Assert
        verify(inputValidation).validateUserRequest(requestDTO);
        verify(userService).createPreRegistry(ArgumentMatchers.any());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
