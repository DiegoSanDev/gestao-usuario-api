package br.com.devspraticar.gestaousuario.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessageType {

    USER_NOT_FOUND("Usuário não encontrado."),
    USER_CREATION_FAILED("Falha ao criar o usuário. Verifique os dados fornecidos."),
    USER_UPDATE_FAILED("Falha ao atualizar o usuário. Verifique os dados fornecidos."),
    USER_NOT_ACTIVE("O usuário não está ativo."),
    USER_EMAIL_ALREADY_IN_USE("O email (%s) fornecido já está em uso por outro usuário."),
    USERNAME_ALREADY_IN_USE("O nome de usuário fornecido já está em uso por outro usuário."),
    USER_VALIDATION_ERROR("Erro de validação nos dados fornecidos.");

    private final String message;
}
