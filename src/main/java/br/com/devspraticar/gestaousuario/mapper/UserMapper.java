package br.com.devspraticar.gestaousuario.mapper;

import br.com.devspraticar.gestaousuario.controller.dto.request.UserPutRequestDto;
import br.com.devspraticar.gestaousuario.controller.dto.request.UserRequestDto;
import br.com.devspraticar.gestaousuario.controller.dto.response.UserResponseDto;
import br.com.devspraticar.gestaousuario.model.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static User toEntity(UserRequestDto requestDto) {
        return User.builder()
            .name(requestDto.name())
            .email(requestDto.email())
            .password(requestDto.password())
            .build();
    }

    public static User toEntity(UserPutRequestDto requestDto) {
        return User.builder()
            .name(requestDto.name())
            .email(requestDto.email())
            .password(requestDto.password())
            .build();
    }

    public static UserResponseDto toUserResponseDto(User user) {
        return UserResponseDto.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .createdAt(user.getCreatedAt())
            .updateAt(user.getUpdateAt())
            .build();
    }

}