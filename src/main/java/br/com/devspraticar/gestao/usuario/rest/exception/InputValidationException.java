package br.com.devspraticar.gestao.usuario.rest.exception;

import br.com.devspraticar.gestao.usuario.rest.dto.ErrorDTO;
import lombok.Getter;

@Getter
public class InputValidationException extends RuntimeException {

    private final transient ErrorDTO errorDTO;

    public InputValidationException(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }

}
