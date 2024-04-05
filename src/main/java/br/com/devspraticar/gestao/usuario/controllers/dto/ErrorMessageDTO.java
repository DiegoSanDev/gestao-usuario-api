package br.com.devspraticar.gestao.usuario.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
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
public class ErrorMessageDTO {

    @Schema(
        name = "message",
        description = "Descrição do problema encontrado.",
        example = "Usuário não autorizado."
    )
    private String message;

    @Schema(
        name = "errors",
        description = "Uma lista de objetos, cada um representando um erro de validação específico.",
        example = "A requisição contém dados inválidos ou ausentes"
    )
    private List<ErrorDTO> errors = new ArrayList<>();

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

}
