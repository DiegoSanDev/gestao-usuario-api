package br.com.devspraticar.gestao.usuario.presentation.controller;

import br.com.devspraticar.gestao.usuario.domain.service.UserService;
import br.com.devspraticar.gestao.usuario.mapper.PreRegistrationMapper;
import br.com.devspraticar.gestao.usuario.mapper.UserMapper;
import br.com.devspraticar.gestao.usuario.presentation.dto.PreRegistrationDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserResponseDTO;
import br.com.devspraticar.gestao.usuario.presentation.validation.InputValidation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "USERS")
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController implements UserAPI {

    private final UserService userService;
    private final InputValidation inputValidation;

    @Override
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PreRegistrationDTO> createPreRegistry(@RequestBody UserRequestDTO body) {
        inputValidation.validateUserRequest(body);
        var preRegistry = userService.createPreRegistry(UserMapper.toDomain(body));
        return ResponseEntity.status(HttpStatus.CREATED).body(PreRegistrationMapper.toResponse(preRegistry));
    }

    @Override
    @PostMapping(value = "/{activationKey}/activate", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> activateUserAccount(@PathVariable(value = "activationKey") UUID activationKey) {
        var user = userService.activateUserAccount(activationKey);
        return ResponseEntity.created(URI.create(String.format("/v1/users/%d", user.getId()))).body(UserMapper.toResponse(user));
    }

}