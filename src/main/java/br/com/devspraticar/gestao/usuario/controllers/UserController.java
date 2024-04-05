package br.com.devspraticar.gestao.usuario.controllers;

import br.com.devspraticar.gestao.usuario.controllers.api.UserAPI;
import br.com.devspraticar.gestao.usuario.controllers.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.controllers.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "USERS")
@RestController
@RequestMapping("/v1/users")
public class UserController implements UserAPI {

    @Override
    public ResponseEntity<UserResponseDTO> createPreRegistry(UserRequestDTO body) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
