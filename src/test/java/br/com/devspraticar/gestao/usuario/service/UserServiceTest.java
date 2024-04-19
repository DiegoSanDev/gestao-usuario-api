package br.com.devspraticar.gestao.usuario.service;

import br.com.devspraticar.gestao.usuario.exception.DuplicateEmailException;
import br.com.devspraticar.gestao.usuario.model.User;
import br.com.devspraticar.gestao.usuario.repository.PreRegistrationRepository;
import br.com.devspraticar.gestao.usuario.repository.UserRepository;
import br.com.devspraticar.gestao.usuario.service.notification.EmailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private EmailService emailService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PreRegistrationRepository preRegistrationRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldLaunchDuplicateEmailException() {
        //Arrange
        var user = User.builder().email(RandomStringUtils.randomAlphanumeric(100)).build();
        when(userRepository.findByEmail(anyString())).thenThrow(new DuplicateEmailException());
        //Act - Assert
        assertThrows(DuplicateEmailException.class, () -> userService.createPreRegistry(user));
    }

}
