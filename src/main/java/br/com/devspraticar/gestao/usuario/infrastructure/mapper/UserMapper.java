package br.com.devspraticar.gestao.usuario.infrastructure.mapper;

import br.com.devspraticar.gestao.usuario.domain.model.User;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserResponseDTO;
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
            .updated(user.getUpdatedAt())
            .dateBirth(user.getDateBirth())
            .build();
    }

}
