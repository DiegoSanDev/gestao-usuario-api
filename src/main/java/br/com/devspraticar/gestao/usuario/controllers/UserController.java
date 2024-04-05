package br.com.devspraticar.gestao.usuario.controllers;

import br.com.devspraticar.gestao.usuario.controllers.api.UserAPI;
import br.com.devspraticar.gestao.usuario.controllers.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.controllers.dto.UserResponseDTO;
import br.com.devspraticar.gestao.usuario.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.devspraticar.gestao.usuario.mapper.UserMapper.toDomain;
import static br.com.devspraticar.gestao.usuario.mapper.UserMapper.toResponse;
import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "USERS")
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController implements UserAPI {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponseDTO> createPreRegistry(UserRequestDTO body) {
        var user = userService.createPreRegistry(toDomain(body));
        return ResponseEntity.status(CREATED).body(toResponse(user));
    }

}