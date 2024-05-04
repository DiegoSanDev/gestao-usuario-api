package br.com.devspraticar.gestao.usuario.exception;

import br.com.devspraticar.gestao.usuario.domain.model.Error;

import static br.com.devspraticar.gestao.usuario.domain.enums.ErrorMessageType.DUPLICATE_EMAIL;

public class DuplicateEmailException extends BaseErrorException {

    @Override
    public Error create() {
        return Error.builder()
            .detail(DUPLICATE_EMAIL.getDetail())
            .description(DUPLICATE_EMAIL.getDescription())
            .build();
    }

}
