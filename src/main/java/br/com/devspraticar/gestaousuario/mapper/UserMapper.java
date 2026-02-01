package br.com.devspraticar.gestaousuario.mapper;

import br.com.devspraticar.gestaousuario.controller.dto.request.UserPutRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.request.UserRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.response.UserResponseDTO;
import br.com.devspraticar.gestaousuario.model.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static User toEntity(UserRequestDTO requestDto) {
        return User.builder()
            .name(requestDto.name())
            .email(requestDto.email())
            .password(requestDto.password())
            .build();
    }

    public static User toEntity(UserPutRequestDTO requestDto) {
        return User.builder()
            .name(requestDto.name())
            .email(requestDto.email())
            .password(requestDto.password())
            .build();
    }

    public static UserResponseDTO toUserResponseDto(User user) {
        return UserResponseDTO.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .createdAt(user.getCreatedAt())
            .updateAt(user.getUpdateAt())
            .build();
    }

}