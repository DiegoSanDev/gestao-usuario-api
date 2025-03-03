package br.com.devspraticar.gestaousuario.mapper;

import br.com.devspraticar.gestaousuario.dto.request.UserRequestDto;
import br.com.devspraticar.gestaousuario.dto.response.UserResponseDto;
import br.com.devspraticar.gestaousuario.entity.User;
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

    public static UserResponseDto toUserResponseDto(User user) {
        return UserResponseDto.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .password(user.getPassword())
            .build();
    }

}