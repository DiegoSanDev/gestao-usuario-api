package br.com.devspraticar.gestaousuario.rest.api;

import br.com.devspraticar.gestaousuario.dto.request.AuthRequestDTO;
import br.com.devspraticar.gestaousuario.dto.response.AuthTokenResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth API", description = "Operações relacionadas ao gerenciamento de login")
public interface AuthApi {

    @Operation(
        summary = "Autenticar usuário e gerar token JWT",
        description = "Recebe email e senha, autentica o usuário e retorna um token JWT válido.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Autenticação bem-sucedida",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = AuthTokenResponseDto.class)
                )
            ),
            @ApiResponse(
                responseCode = "401",
                description = "Credenciais inválidas",
                content = @Content
            )
        }
    )
    @PostMapping("/login")
    ResponseEntity<AuthTokenResponseDto> authenticate(@RequestBody AuthRequestDTO loginRequest);

}