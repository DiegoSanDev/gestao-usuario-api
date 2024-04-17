package br.com.devspraticar.gestao.usuario.service;

import br.com.devspraticar.gestao.usuario.exception.PreRegistryErrorException;
import br.com.devspraticar.gestao.usuario.exception.DuplicateEmailException;
import br.com.devspraticar.gestao.usuario.model.PreRegistration;
import br.com.devspraticar.gestao.usuario.model.User;
import br.com.devspraticar.gestao.usuario.repository.PreRegistrationRepository;
import br.com.devspraticar.gestao.usuario.repository.UserRepository;
import br.com.devspraticar.gestao.usuario.service.notification.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private static final int EXPIRATIONDATE_PERIOD_AT_DAY = 2;

    private final EmailService emailService;
    private final UserRepository userRepository;
    private final PreRegistrationRepository preRegistrationRepository;

    @Transactional
    public User createPreRegistry(User user) {
        validateUser(user);
        User userSave;
        try {
            user.setCreatedAt(LocalDateTime.now());
            userSave = userRepository.save(user);
            savePreRegistration(userSave);
        } catch (Exception e) {
            log.error("Erro sao criar o pré-cadastro. {}", user, e);
            throw new PreRegistryErrorException();
        }
        emailService.sendEmailUser(user);
        return userSave;
    }

    private void validateUser(User user) {
        userRepository.findByEmail(user.getEmail())
            .ifPresent(existingUser -> { throw new DuplicateEmailException(); });
    }

    private void savePreRegistration(User user) {
        var preRegistration = PreRegistration.builder()
            .userId(user.getId())
            .hash(UUID.randomUUID().toString())
            .expirationDate(LocalDateTime.now()
                .plusDays(EXPIRATIONDATE_PERIOD_AT_DAY))
            .build();
        preRegistrationRepository.save(preRegistration);
    }

}