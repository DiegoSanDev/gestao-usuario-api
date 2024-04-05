package br.com.devspraticar.gestao.usuario.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    @Schema(
        name = "field",
        description = "O nome do campo que possui um erro de vailidação",
        example = "name"
    )
    private String field;

    @Schema(
        name = "message",
        description = "Uma mensagem específica indicando o problema encontado no campo.",
        example = "O campo '{ name }' é obrigátorio."
    )
    private String message;

}
