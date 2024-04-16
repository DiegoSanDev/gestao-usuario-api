package br.com.devspraticar.gestao.usuario.service.notification;

import br.com.devspraticar.gestao.usuario.exception.MailSendException;
import br.com.devspraticar.gestao.usuario.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendEmailUser(User user) {
        try {
            var message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setFrom("devspraticar@gmail.com");
            message.setText(createMessageText(user));
            message.setSubject("Ativar Cadastro de Usuario");
            javaMailSender.send(message);
        } catch (MailException e) {
            log.error("Erro ao tentar enviar email. {}", user, e);
            throw new MailSendException();
        }
    }

    private String createMessageText(User user) {
        var message = new StringBuilder("Olá,");
        message.append(user.getName()).append(".")
            .append("Recebemos sua solicitação de cadastro nos canais digitais.")
            .append("Para utilizar  nossos serviços online, é essencial que ative seu cadastro através do link fornecido abaixo:")
            .append("Ativar Cadastro")
            .append("Caso não tenha solicitado este cadastro, por favor, ignore este e-mail.")
            .append("Atenciosamente,")
            .append(" ")
            .append("Equipe DevsPraticar");
        return message.toString();
    }

}
