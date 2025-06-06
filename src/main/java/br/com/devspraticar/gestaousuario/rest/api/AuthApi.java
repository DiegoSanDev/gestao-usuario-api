package br.com.devspraticar.gestaousuario.rest.api;

import br.com.devspraticar.gestaousuario.dto.request.AuthRequestDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Tag(name = "Auth API", description = "Operações relacionadas ao gerenciamento de login")
public interface AuthApi {

    @PostMapping("/login")
    ResponseEntity<Map<String, String>> authenticate(@RequestBody AuthRequestDTO loginRequest);
}
