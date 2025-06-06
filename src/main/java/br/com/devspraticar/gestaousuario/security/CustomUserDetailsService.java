package br.com.devspraticar.gestaousuario.security;

import br.com.devspraticar.gestaousuario.exception.UserNotFoundException;
import br.com.devspraticar.gestaousuario.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new);
        return UserSecurity.builder().user(user).build();
    }

}