package br.com.devspraticar.gestao.usuario;

import br.com.devspraticar.gestao.usuario.model.entities.PreRegistration;
import br.com.devspraticar.gestao.usuario.model.entities.User;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@UtilityClass
public class MockUtils {

    private static final Supplier<Random> randomSupplier = Random::new;

    public static User getUserMock () {
        var random = randomSupplier.get();
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

    public static PreRegistration getPreRegistrationMock() {
        var random = randomSupplier.get();
        return PreRegistration.builder()
            .id(random.nextLong())
            .userId(random.nextLong())
            .active(random.nextBoolean())
            .activationKey(UUID.randomUUID())
            .expirationDate(LocalDate.now())
            .build();
    }

}
