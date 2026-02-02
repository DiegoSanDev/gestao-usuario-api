package br.com.devspraticar.gestaousuario.controller.api;

import br.com.devspraticar.gestaousuario.controller.dto.request.AuthRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.request.RefreshTokenRequestDTO;
import br.com.devspraticar.gestaousuario.controller.dto.response.AuthTokenResponseDTO;
import br.com.devspraticar.gestaousuario.controller.dto.response.ErrorMessageDTO;
import br.com.devspraticar.gestaousuario.controller.dto.response.TokenErrorMessageDTO;
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
        summary = "Autenticar usuário",
        description = """
        Autentica o usuário a partir de e-mail e senha.
        
        Retorna:
        - Access Token (JWT) para autenticação nas requisições
        - Refresh Token para renovação do token de acesso
        """,
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Autenticação realizada com sucesso",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AuthTokenResponseDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Dados inválidos na requisição",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorMessageDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "401",
                description = "Credenciais inválidas",
                content = @Content
            )
        }
    )
    ResponseEntity<AuthTokenResponseDTO> authenticate(@RequestBody AuthRequestDTO loginRequest);

    @Operation(
        summary = "Renovar tokens de autenticação",
        description = """
        Gera um novo Access Token e um novo Refresh Token a partir de um refresh token válido.
        O refresh token anterior é automaticamente revogado (refresh token rotation).
        """,
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Token renovado com sucesso",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AuthTokenResponseDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Refresh token não informado ou inválido",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenErrorMessageDTO.class)
                )
            ),
            @ApiResponse(
                responseCode = "401",
                description = "Refresh token expirado ou revogado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenErrorMessageDTO.class)
                )
            )
        }
    )
    ResponseEntity<AuthTokenResponseDTO> refreshToken(@RequestBody RefreshTokenRequestDTO request);


    @Operation(
        summary = "Encerrar sessão do usuário (logout)",
        description = """
        Realiza o logout do usuário revogando o refresh token informado.
        
        Comportamento:
        - O refresh token é marcado como revogado
        - Novas tentativas de refresh com este token serão rejeitadas
        - O access token atual continuará válido até expirar
        
        Observações:
        - Endpoint idempotente: múltiplas chamadas com o mesmo token não causam erro
        """,
        responses = {
            @ApiResponse(
                responseCode = "204",
                description = "Logout realizado com sucesso (refresh token revogado)"
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Refresh token não informado ou formato inválido",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorMessageDTO.class)
                )
            )
        }
    )
    ResponseEntity<Void> logout(@RequestBody RefreshTokenRequestDTO request);

}