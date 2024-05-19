package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.model.entities.Error;

import static br.com.devspraticar.gestao.usuario.model.enums.ErrorMessageType.ACTIVATION_KEY_EXPIRED;

public class AccountActivationExpiredException extends BaseErrorException {

    @Override
    public Error create() {
        return Error.builder()
            .detail(ACTIVATION_KEY_EXPIRED.getDetail())
            .description(ACTIVATION_KEY_EXPIRED.getDescription())
            .build();
    }

}
