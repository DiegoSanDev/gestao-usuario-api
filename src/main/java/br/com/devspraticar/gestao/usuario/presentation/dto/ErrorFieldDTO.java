package br.com.devspraticar.gestao.usuario.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorFieldDTO {

    @Schema(
        name = "message",
        description = "Mensagem detalhada do erro",
        example = "O endereço de email fornecido não está em um formato válido."
    )
    private String message;

    @Schema(
        name = "propertyName",
        description = "Nome da propiedade",
        example = "email"
    )
    private String propertyName;

}
