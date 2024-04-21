package br.com.devspraticar.gestao.usuario.service.notification;

import br.com.devspraticar.gestao.usuario.exception.MailSendException;
import br.com.devspraticar.gestao.usuario.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        } catch (Exception e) {
            log.error("Erro ao tentar enviar email. {}", user, e);
            throw new MailSendException();
        }
    }

    private String createMessageText(User user) {
        return "<html>" +
                "<body>" +
                "<p>Olá, " + user.getName() + ",</p>" +
                "<p>Recebemos sua solicitação de cadastro nos canais digitais.</p>" +
                "<p>Para utilizar nossos serviços online, é essencial que ative seu cadastro através do link fornecido abaixo:</p>" +
                "<p><a href=\"link_para_ativar_cadastro\">Ativar Cadastro</a></p>" +
                "<p>Caso não tenha solicitado este cadastro, por favor, ignore este e-mail.</p>" +
                "<p>Atenciosamente,</p>" +
                "<p>Equipe DevsPraticar</p>" +
                "</body>" +
                "</html>";
    }

}
