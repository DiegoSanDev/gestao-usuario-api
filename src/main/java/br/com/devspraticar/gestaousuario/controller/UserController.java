package br.com.devspraticar.gestaousuario.controller;

import br.com.devspraticar.gestaousuario.controller.dto.request.UserPutRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.request.UserRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.response.UserResponseDTO;
import br.com.devspraticar.gestaousuario.controller.validator.InputValidation;
import br.com.devspraticar.gestaousuario.model.entity.User;
import br.com.devspraticar.gestaousuario.mapper.UserMapper;
import br.com.devspraticar.gestaousuario.controller.api.UserApi;
import br.com.devspraticar.gestaousuario.model.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final InputValidation inputValidation;

    @Override
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userRequestDto) {
        inputValidation.validate(userRequestDto);
        User userEntity = userService.create(UserMapper.toEntity(userRequestDto));
        UserResponseDTO userResponse = UserMapper.toUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@RequestBody UserPutRequestDTO userRequestDto, @PathVariable("id") Long id) {
        inputValidation.validate(userRequestDto);
        User userUpdate = userService.update(UserMapper.toEntity(userRequestDto), id);
        UserResponseDTO userResponse = UserMapper.toUserResponseDto(userUpdate);
        return ResponseEntity.ok(userResponse);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(UserMapper.toUserResponseDto(userService.findById(id)));
    }

}