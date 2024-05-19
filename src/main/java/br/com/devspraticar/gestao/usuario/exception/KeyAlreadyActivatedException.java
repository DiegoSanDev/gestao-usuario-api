package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.model.entities.Error;

import static br.com.devspraticar.gestao.usuario.model.enums.ErrorMessageType.KEY_ALREADY_ACTIVATED;

public class KeyAlreadyActivatedException extends BaseErrorException {

    @Override
    public Error create() {
        return Error.builder()
            .detail(KEY_ALREADY_ACTIVATED.getDetail())
            .description(KEY_ALREADY_ACTIVATED.getDescription())
            .build();
    }

}
