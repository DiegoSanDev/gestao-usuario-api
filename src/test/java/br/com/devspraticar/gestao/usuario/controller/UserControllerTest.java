package br.com.devspraticar.gestao.usuario.controller;

import br.com.devspraticar.gestao.usuario.model.User;
import br.com.devspraticar.gestao.usuario.rest.controller.UserController;
import br.com.devspraticar.gestao.usuario.rest.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.rest.dto.UserResponseDTO;
import br.com.devspraticar.gestao.usuario.service.UserService;
import br.com.devspraticar.gestao.usuario.validation.InputValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

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
        var user = new User();
        user.setId(1L);
        var expectedResponseDTO = new UserResponseDTO();
        expectedResponseDTO.setId(user.getId());
        doNothing().when(inputValidation).validateUserRequest(requestDTO);
        when(userService.createPreRegistry(ArgumentMatchers.any())).thenReturn(user);
        //Act
        ResponseEntity<UserResponseDTO> response = userController.createPreRegistry(requestDTO);
        //Assert
        verify(inputValidation).validateUserRequest(requestDTO);
        verify(userService).createPreRegistry(ArgumentMatchers.any());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(URI.create("/v1/users/1"), response.getHeaders().getLocation());
    }

}
