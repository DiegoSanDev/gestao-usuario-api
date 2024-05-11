package br.com.devspraticar.gestao.usuario.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessageType {

    VALIDATION_ERROR( "Error de validação", "Falha na validação dos dados de entrada."),
    RESOURCE_NOT_FOUND( "Recurso não encontrado", "Recurso solicitado não foi encontrado."),
    KEY_ALREADY_ACTIVATED("Chave já foi ativada", "Chave de ativação de cadastro já foi ativada."),
    DUPLICATE_EMAIL( "E-mail duplicado", "Já existe um usuário com o mesmo endereço de e-mail fornecido."),
    ERROR_SEND_EMAIL( "Falha ao enviar e-mail ", "Não foi possível enviar o e-mail de ativação de cadastro."),
    ACTIVATION_KEY_EXPIRED("Chave de ativação expirada", "Não foi possível realizar a ativação da conta do usuário."),
    USER_NOT_FOUND( "Usuário não encontrado", "Não foi possível realizar a ativação da conta, usuário não encontrado."),
    PRE_REGISTRY_ERROR("Falha ao criar pré-cadastro", "Não foi possível realizar o pré-cadastro. Tente novamente mais tarde."),
    ACTIVATION_KEY_NOT_FOUND( "Chave de ativação não encontrada", "Não foi possível realizar a ativação da conta do usuário.");

    private final String description;
    private final String detail;

}
