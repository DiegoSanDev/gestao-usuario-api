package br.com.devspraticar.gestao.usuario.presentation.controller;

import br.com.devspraticar.gestao.usuario.presentation.dto.ErrorDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.PreRegistrationDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface UserAPI {

    @Operation(summary = " Endpoint utilizado para criar um novo pré-cadastro do usuário na aplicação.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created",
            content = { @Content(mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = PreRegistrationDTO.class))
            }
        ),
        @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
            content = { @Content(mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorDTO.class))
            }
        ),
        @ApiResponse(responseCode = "409", description = "Conflict",
            content = { @Content(mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorDTO.class))
            }
        ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(schema = @Schema)}
        ),
        @ApiResponse(responseCode = "503", description = "Service Unavailable",
            content = {@Content(schema = @Schema)}
        )
    })
    ResponseEntity<PreRegistrationDTO> createPreRegistry(UserRequestDTO body);

    @Operation(summary = " Endpoint utilizado para criar a ativação da conta do usuário.")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201", description = "Created",
            content = { @Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UserResponseDTO.class))
            }
        ),
        @ApiResponse(responseCode = "400", description = "Bad Request",
            content = { @Content(mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(example = """
                    {
                     "detail": "Chave de ativação da conta inválida",
                     "description": "Chave inválida"
                    }"""))
            }
        ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = {@Content(schema = @Schema)}
        ),
        @ApiResponse(responseCode = "503", description = "Service Unavailable",
            content = {@Content(schema = @Schema)}
        )
    })
    ResponseEntity<UserResponseDTO> activateUserAccount(UUID activationKey);

}
