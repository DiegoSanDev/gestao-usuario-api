package br.com.devspraticar.gestaousuario.controller;

import br.com.devspraticar.gestaousuario.controller.dto.request.UserPutRequestDto;
import br.com.devspraticar.gestaousuario.controller.dto.request.UserRequestDto;
import br.com.devspraticar.gestaousuario.controller.dto.response.UserResponseDto;
import br.com.devspraticar.gestaousuario.model.entity.User;
import br.com.devspraticar.gestaousuario.mapper.UserMapper;
import br.com.devspraticar.gestaousuario.controller.api.UserApi;
import br.com.devspraticar.gestaousuario.model.service.UserService;
import br.com.devspraticar.gestaousuario.controller.validator.UserRequestInputValidation;
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
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserRequestInputValidation inputValidation;

    @Override
    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userRequestDto) {
        inputValidation.validate(userRequestDto);
        User userEntity = userService.create(UserMapper.toEntity(userRequestDto));
        UserResponseDto userResponse = UserMapper.toUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@RequestBody UserPutRequestDto userRequestDto, @PathVariable("id") Long id) {
        User userUpdate = userService.update(UserMapper.toEntity(userRequestDto), id);
        UserResponseDto userResponse = UserMapper.toUserResponseDto(userUpdate);
        return ResponseEntity.ok(userResponse);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(UserMapper.toUserResponseDto(userService.findById(id)));
    }
}