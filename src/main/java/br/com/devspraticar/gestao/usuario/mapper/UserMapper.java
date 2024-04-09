package br.com.devspraticar.gestao.usuario.mapper;

import br.com.devspraticar.gestao.usuario.controllers.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.controllers.dto.UserResponseDTO;
import br.com.devspraticar.gestao.usuario.models.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User toDomain(UserRequestDTO userRequestDTO) {
        return User.builder()
            .name(userRequestDTO.getName())
            .email(userRequestDTO.getEmail())
            .password(userRequestDTO.getPassword())
            .dateBirth(userRequestDTO.getDateBirth())
            .build();
    }

    public UserResponseDTO toResponse(User user) {
        return UserResponseDTO.builder()
            .id(user.getId())
            .name(user.getName())
            .password("********")
            .email(user.getEmail())
            .active(user.isActive())
            .created(user.getCreatedAt())
            .dateBirth(user.getDateBirth())
            .build();
    }

}
