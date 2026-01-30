package br.com.devspraticar.gestaousuario.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {

    USER,
    MODERATOR,
    ADMINISTRATOR

}