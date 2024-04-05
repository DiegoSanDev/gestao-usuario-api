package br.com.devspraticar.gestao.usuario.service;

import br.com.devspraticar.gestao.usuario.models.User;
import br.com.devspraticar.gestao.usuario.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User createPreRegistry(User user) {

        userRepository.findByEmail(user.getEmail())
            .ifPresent(existingUser -> {
                throw new IllegalStateException(String.format("E-mail: %s já cadastrado", user.getEmail()));
            });
        //userRepository.save(user);
        return User.builder().build();
    }

}
