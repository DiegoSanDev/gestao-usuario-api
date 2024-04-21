package br.com.devspraticar.gestao.usuario.service.notification;

import br.com.devspraticar.gestao.usuario.MockUtils;
import br.com.devspraticar.gestao.usuario.exception.MailSendException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    void shouldSendEmailUser_Success() {
        //Arrange
        var user = MockUtils.getUserMock();
        //Act
        emailService.sendEmailUser(user);
        //Assert
        verify(javaMailSender).send(any(SimpleMailMessage.class));
    }

    @Test
    void shouldLaunch_MailSendException() {
        //Arrange
        var user = MockUtils.getUserMock();
        var message = new SimpleMailMessage();
        message.setText("ww");
        doThrow(RuntimeException.class).when(javaMailSender).send(message);
        //Act - Assert
        assertThrows(MailSendException.class, () -> emailService.sendEmailUser(user));
    }

}
