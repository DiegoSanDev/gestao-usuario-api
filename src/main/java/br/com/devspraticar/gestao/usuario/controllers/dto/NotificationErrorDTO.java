package br.com.devspraticar.gestao.usuario.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationErrorDTO {

    @Schema(
        name = "message",
        description = "Uma mensagem geral indicando que a requisição contém dados inválidos ou ausentes.",
        example = "A requisição contém dados inválidos ou ausentes"
    )
    private String message;

    @Schema(
        name = "errors",
        description = "Uma lista de objetos, cada um representando um erro de validação específico."
    )
    private List<ErrorDTO> errors = new ArrayList<>();

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

}
