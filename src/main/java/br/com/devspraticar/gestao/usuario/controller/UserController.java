package br.com.devspraticar.gestao.usuario.controller;

import br.com.devspraticar.gestao.usuario.controller.api.UserAPI;
import br.com.devspraticar.gestao.usuario.controller.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.controller.dto.UserResponseDTO;
import br.com.devspraticar.gestao.usuario.mapper.UserMapper;
import br.com.devspraticar.gestao.usuario.service.InputValidation;
import br.com.devspraticar.gestao.usuario.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Tag(name = "USERS")
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController implements UserAPI {

    private final UserService userService;
    private final InputValidation inputValidation;

    @Override
    public ResponseEntity<UserResponseDTO> createPreRegistry(UserRequestDTO body) {
        inputValidation.validateUserRequest(body);
        var user = userService.createPreRegistry(UserMapper.toDomain(body));
        return ResponseEntity.created(URI.create(String.format("/v1/users/%d", user.getId()))).body(UserMapper.toResponse(user));
    }

}