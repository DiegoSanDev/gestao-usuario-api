package br.com.devspraticar.gestao.usuario.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessageType {

    VALIDATION_ERROR("ERR001", "Error de validação", "Falha na validação dos dados de entrada"),
    RESOURCE_NOT_FOUND("ERR002", "Recurso não encontrado", "Recurso solicitado não foi encontrado"),
    DUPLICATE_EMAIL("ERR003", "E-mail duplicado", "Já existe um usuário com o mesmo endereço de e-mail fornecido");

    private final String code;
    private final String description;
    private final String detail;

}
