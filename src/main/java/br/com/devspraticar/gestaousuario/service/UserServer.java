package br.com.devspraticar.gestaousuario.service;

import br.com.devspraticar.gestaousuario.entity.Role;
import br.com.devspraticar.gestaousuario.entity.User;
import br.com.devspraticar.gestaousuario.enums.RoleType;
import br.com.devspraticar.gestaousuario.enums.UserType;
import br.com.devspraticar.gestaousuario.exception.EmailAlreadyExistsException;
import br.com.devspraticar.gestaousuario.exception.InternalServerErrorException;
import br.com.devspraticar.gestaousuario.exception.RoleNotFoundException;
import br.com.devspraticar.gestaousuario.exception.UserNotFoundException;
import br.com.devspraticar.gestaousuario.repository.RoleRepository;
import br.com.devspraticar.gestaousuario.repository.UserRepository;
import br.com.devspraticar.gestaousuario.validator.FieldValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public User create(User user) {
        userRepository.findByEmail(user.getEmail())
            .ifPresent(userPresent -> { throw new EmailAlreadyExistsException(userPresent.getEmail()); });
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            setRole(user);
            return userRepository.save(user);
        } catch (Exception e) {
            log.error("Erro ao tentar criar usuário: {}", user, e);
            throw new InternalServerErrorException();
        }
    }

    public User update(User user, Long id) {
        User userToUpdate = this.findById(id);
        if (isEmailPresent(user.getEmail()) && !userToUpdate.getEmail().equals(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }
        try {
            userToUpdate.setEmail(user.getEmail());
            FieldValidator.validateAndUpdate(user.getName(), userToUpdate::setName);
            FieldValidator.validateAndUpdate(user.getPassword(), userToUpdate::setPassword);
            userRepository.save(userToUpdate);
            return userToUpdate;
        } catch (Exception e) {
            log.error("Erro ao tentar atualizar usuário: {}", user, e);
            throw new InternalServerErrorException();
        }
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    private void setRole(User user) {
        Role role =  findRoleByName(RoleType.ROLE_USER.name());
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
    }

    private Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName).orElseThrow(RoleNotFoundException::new);
    }

    private boolean isEmailPresent(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}