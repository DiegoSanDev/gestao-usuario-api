package br.com.devspraticar.gestaousuario.rest.api;

import br.com.devspraticar.gestaousuario.dto.request.UserPutRequestDto;
import br.com.devspraticar.gestaousuario.dto.request.UserRequestDto;
import br.com.devspraticar.gestaousuario.dto.response.UserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserApi {

    ResponseEntity<UserResponseDto> create(UserRequestDto userRequestDto);

    ResponseEntity<UserResponseDto> update(UserPutRequestDto userRequestDto, Long id);

    ResponseEntity<UserResponseDto> findId(Long id);

}
