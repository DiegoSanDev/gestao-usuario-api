package br.com.devspraticar.gestao.usuario.service;

import br.com.devspraticar.gestao.usuario.exception.UserAlreadyExistsException;
import br.com.devspraticar.gestao.usuario.model.PreRegistration;
import br.com.devspraticar.gestao.usuario.model.User;
import br.com.devspraticar.gestao.usuario.repository.PreRegistrationRepository;
import br.com.devspraticar.gestao.usuario.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final int EXPIRATIONDATE_PERIOD_AT_DAY = 2;

    private final UserRepository userRepository;
    private final PreRegistrationRepository preRegistrationRepository;

    @Transactional
    public User createPreRegistry(User user) {
        validateUser(user);
        user.setCreatedAt(LocalDateTime.now());
        var userSave = userRepository.save(user);
        savePreRegistration(userSave);
        return userSave;
    }

    private void validateUser(User user) {
        userRepository.findByEmail(user.getEmail())
            .ifPresent(existingUser -> { throw new UserAlreadyExistsException(); });
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