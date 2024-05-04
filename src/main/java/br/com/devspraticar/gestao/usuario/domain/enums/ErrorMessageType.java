package br.com.devspraticar.gestao.usuario.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessageType {

    VALIDATION_ERROR( "Error de validação", "Falha na validação dos dados de entrada."),
    RESOURCE_NOT_FOUND( "Recurso não encontrado", "Recurso solicitado não foi encontrado."),
    DUPLICATE_EMAIL( "E-mail duplicado", "Já existe um usuário com o mesmo endereço de e-mail fornecido."),
    ERROR_SEND_EMAIL( "Falha ao enviar e-mail ", "Não foi possível enviar o e-mail de ativação de cadastro."),
    PRE_REGISTRY_ERROR("Falha ao criar pré-cadastro", "Não foi possível realizar o pré-cadastro. Tente novamente mais tarde");

    private final String description;
    private final String detail;

}
