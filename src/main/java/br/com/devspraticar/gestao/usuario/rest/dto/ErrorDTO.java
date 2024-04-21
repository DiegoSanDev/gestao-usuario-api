package br.com.devspraticar.gestao.usuario.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {

    @Schema(
        name = "detail",
        description = "Detalhe do erro",
        example = "Falha na validação dos dados de entrada"
    )
    private String detail;

    @Schema(
        name = "description",
        description = "Descrição do erro",
        example = "Error de validação"
    )
    private String description;

    @Schema(
        name = "errors",
        description = "Lista com a descrição dos erros",
        nullable = true
    )
    private List<ErrorFieldDTO> errors;

}
