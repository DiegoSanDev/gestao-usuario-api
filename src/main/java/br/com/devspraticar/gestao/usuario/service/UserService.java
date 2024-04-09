package br.com.devspraticar.gestao.usuario.service;

import br.com.devspraticar.gestao.usuario.exception.UserAlreadyExistsException;
import br.com.devspraticar.gestao.usuario.models.PreRegistration;
import br.com.devspraticar.gestao.usuario.models.User;
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

    private final UserRepository userRepository;
    private final PreRegistrationRepository preRegistrationRepository;

    @Transactional
    public User createPreRegistry(User user) {
        userRepository.findByEmail(user.getEmail())
            .ifPresent(existingUser -> { throw new UserAlreadyExistsException(); });
        user.setCreatedAt(LocalDateTime.now());
        var userSave = userRepository.save(user);
        var preRegistration = PreRegistration.builder()
            .userId(user.getId())
            .hash(UUID.randomUUID().toString())
            .expirationDate(LocalDateTime.now().plusDays(2))
            .build();
        preRegistrationRepository.save(preRegistration);
        return userSave;
    }

}