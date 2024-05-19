package br.com.devspraticar.gestao.usuario.model.service;

import br.com.devspraticar.gestao.usuario.model.entities.PreRegistration;
import br.com.devspraticar.gestao.usuario.model.entities.User;
import br.com.devspraticar.gestao.usuario.exception.AccountActivationExpiredException;
import br.com.devspraticar.gestao.usuario.exception.DuplicateEmailException;
import br.com.devspraticar.gestao.usuario.exception.KeyAlreadyActivatedException;
import br.com.devspraticar.gestao.usuario.exception.NotFoundException;
import br.com.devspraticar.gestao.usuario.exception.PreRegistryErrorException;
import br.com.devspraticar.gestao.usuario.infrastructure.repository.PreRegistrationRepository;
import br.com.devspraticar.gestao.usuario.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

import static br.com.devspraticar.gestao.usuario.model.enums.ErrorMessageType.ACTIVATION_KEY_NOT_FOUND;
import static br.com.devspraticar.gestao.usuario.model.enums.ErrorMessageType.USER_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private static final int EXPIRATIONDATE_PERIOD_AT_DAY = 2;

    private final UserRepository userRepository;
    private final PreRegistrationRepository preRegistrationRepository;

    @Transactional
    public PreRegistration createPreRegistry(User user) {
        validateUserExistsWithEmail(user);
        PreRegistration preRegistration;
        try {
            user.setCreatedAt(LocalDateTime.now());
            var userSave = userRepository.save(user);
            preRegistration = savePreRegistration(userSave);
        } catch (Exception e) {
            log.error("Erro ao criar o pré-cadastro. {}", user, e);
            throw new PreRegistryErrorException();
        }
        return preRegistration;
    }

    @Transactional
    public User activateUserAccount(UUID activationKey) {
        var preRegistration = validationActivateAccount(activationKey);
        preRegistration.setActive(false);
        preRegistrationRepository.save(preRegistration);
        return activateUser(preRegistration.getUserId());
    }

    private PreRegistration validationActivateAccount(UUID activationKey) {
        PreRegistration preRegistration = preRegistrationRepository.findByActivationKey(activationKey)
            .orElseThrow(() -> new NotFoundException(ACTIVATION_KEY_NOT_FOUND.getDetail(), ACTIVATION_KEY_NOT_FOUND.getDescription()));
        if (LocalDateTime.now().isAfter(preRegistration.getExpirationDate())) {
            throw new AccountActivationExpiredException();
        }
        if (!preRegistration.isActive()) {
            throw new KeyAlreadyActivatedException();
        }
        return preRegistration;
    }

    private User activateUser(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND.getDetail(), USER_NOT_FOUND.getDescription()));
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    private void validateUserExistsWithEmail(User user) {
        userRepository.findByEmail(user.getEmail())
            .ifPresent(existingUser -> { throw new DuplicateEmailException(); });
    }

    private PreRegistration savePreRegistration(User user) {
        var preRegistration = PreRegistration.builder()
            .userId(user.getId())
            .active(Boolean.TRUE)
            .activationKey(UUID.randomUUID())
            .expirationDate(LocalDateTime.now()
                .plusDays(EXPIRATIONDATE_PERIOD_AT_DAY))
            .build();
        return preRegistrationRepository.save(preRegistration);
    }

}