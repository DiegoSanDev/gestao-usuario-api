package br.com.devspraticar.gestao.usuario.presentation.exception;

import br.com.devspraticar.gestao.usuario.presentation.dto.ErrorDTO;
import lombok.Getter;

@Getter
public class InputValidationException extends RuntimeException {

    private final transient ErrorDTO errorDTO;

    public InputValidationException(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }

}
