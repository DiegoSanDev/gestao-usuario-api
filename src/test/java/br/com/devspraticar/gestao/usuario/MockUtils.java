package br.com.devspraticar.gestao.usuario;

import br.com.devspraticar.gestao.usuario.model.User;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@UtilityClass
public class MockUtils {

    public static User getUserMock () {
        var random = new Random();
        return User.builder()
            .id(random.nextLong())
            .dateBirth(LocalDate.now())
            .active(random.nextBoolean())
            .updatedAt(LocalDateTime.now())
            .createdAt(LocalDateTime.now())
            .name(RandomStringUtils.randomAlphabetic(50))
            .email(RandomStringUtils.randomAlphanumeric(100))
            .password(RandomStringUtils.randomAlphanumeric(12))
            .build();
    }

}
