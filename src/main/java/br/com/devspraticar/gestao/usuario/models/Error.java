package br.com.devspraticar.gestao.usuario.models;

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
public class Error {

    private String detail;
    private int httpStatuCode;
    private String description;

}
