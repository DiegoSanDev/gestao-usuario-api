package br.com.devspraticar.gestao.usuario.mapper;

import br.com.devspraticar.gestao.usuario.MockUtils;
import br.com.devspraticar.gestao.usuario.model.mapper.UserMapper;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserRequestDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {

    @Test
    void shouldMapToDomain() {
        //Arrange
        var userRequest = UserRequestDTO.builder()
            .dateBirth(LocalDate.now())
            .name(randomAlphabetic(10))
            .email(randomAlphanumeric(20))
            .password(randomAlphabetic(12))
            .build();
        //Act
        var result = UserMapper.toDomain(userRequest);
        //Assert
        assertEquals(userRequest.getName(), result.getName());
        assertEquals(userRequest.getEmail(), result.getEmail());
        assertEquals(userRequest.getPassword(), result.getPassword());
        assertEquals(userRequest.getDateBirth(), result.getDateBirth());
    }

    @Test
    void shouldMapToResponse() {
        //Arrange
        var user = MockUtils.getUserMock();
        //Act
        var result = UserMapper.toResponse(user);
        //Assert
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getName(), result.getName());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.isActive(), result.isActive());
        assertEquals("********", result.getPassword());
        assertEquals(user.getUpdatedAt().getDayOfMonth(), result.getUpdated().getDayOfMonth());
        assertEquals(user.getCreatedAt().getDayOfMonth(), result.getCreated().getDayOfMonth());
    }

}
