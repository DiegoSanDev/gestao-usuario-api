package br.com.devspraticar.gestao.usuario.controller.exception;

import br.com.devspraticar.gestao.usuario.controller.dto.ErrorDTO;
import lombok.Getter;

@Getter
public class InputValidationException extends RuntimeException {

    private final transient ErrorDTO errorDTO;

    public InputValidationException(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }

}
