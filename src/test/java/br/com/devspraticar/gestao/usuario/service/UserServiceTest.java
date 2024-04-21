package br.com.devspraticar.gestao.usuario.service;

import br.com.devspraticar.gestao.usuario.MockUtils;
import br.com.devspraticar.gestao.usuario.exception.DuplicateEmailException;
import br.com.devspraticar.gestao.usuario.exception.PreRegistryErrorException;
import br.com.devspraticar.gestao.usuario.model.PreRegistration;
import br.com.devspraticar.gestao.usuario.model.User;
import br.com.devspraticar.gestao.usuario.repository.PreRegistrationRepository;
import br.com.devspraticar.gestao.usuario.repository.UserRepository;
import br.com.devspraticar.gestao.usuario.service.notification.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.devspraticar.gestao.usuario.MockUtils.getUserMock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
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
    void shouldLaunch_DuplicateEmailException() {
        //Arrange
        var user = getUserMock();
        when(userRepository.findByEmail(anyString())).thenThrow(new DuplicateEmailException());
        //Act - Assert
        assertThrows(DuplicateEmailException.class, () -> userService.createPreRegistry(user));
    }

    @Test
    void shouldLaunch_PreRegistryErrorException() {
        //Arrange
        var user = getUserMock();
        when(userRepository.save(any(User.class))).thenThrow(new PreRegistryErrorException());
        //Act - Assert
        assertThrows(PreRegistryErrorException.class, () -> userService.createPreRegistry(user));
    }

    @Test
    void shouldSave_userPreRegistry() {
        //Arrange
        var user = MockUtils.getUserMock();
        when(userRepository.save(any(User.class))).thenReturn(user);
        doNothing().when(emailService).sendEmailUser(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(preRegistrationRepository.save(any(PreRegistration.class))).thenReturn(PreRegistration.builder().build());
        //Act
        var userSave = userService.createPreRegistry(user);
        //Assert
        assertEquals(user.getId(), userSave.getId());
    }

}
