package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.model.Error;

import static br.com.devspraticar.gestao.usuario.enums.ErrorMessageType.ERROR_SEND_EMAIL;

public class PreRegistryErrorException extends BaseErrorException {

    @Override
    public Error create() {
        return Error.builder()
            .detail(ERROR_SEND_EMAIL.getDetail())
            .description(ERROR_SEND_EMAIL.getDescription())
            .build();
    }

}
