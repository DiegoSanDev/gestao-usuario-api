package br.com.devspraticar.gestaousuario.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {

    ROLE_USER("Permissão de usuário comum"),
    ROLE_ADMIN("Permissão de administrador"),
    ROLE_MODERATOR("Permissão de moderador");

    private final String description;

}