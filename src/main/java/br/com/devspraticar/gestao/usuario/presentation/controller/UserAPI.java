package br.com.devspraticar.gestao.usuario.presentation.controller;

import br.com.devspraticar.gestao.usuario.presentation.dto.ErrorDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.presentation.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface UserAPI {

    @Operation(summary = " Endpoint utilizado para criar um novo pré-cadastro do usuário na aplicação.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created",
            content = { @Content(mediaType = APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = UserResponseDTO.class))
            },
            headers = {
                @Header(name = "location", schema = @Schema(type = "string"),
                    description = "Local onde o registro cadastrado pode ser encontrado.",
                    example = "/v1/users/1")
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
        )
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDTO> createPreRegistry(@RequestBody UserRequestDTO body);

}
