package br.com.devspraticar.gestaousuario.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {

    ROLE_USER("Permissão de administrador"),
    ROLE_ADMIN("Permissão de usuário comum"),
    ROLE_MODERATOR("Permissão de moderador");

    private final String description;

}