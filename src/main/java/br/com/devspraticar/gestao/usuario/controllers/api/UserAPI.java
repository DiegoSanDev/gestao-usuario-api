package br.com.devspraticar.gestao.usuario.controllers.api;

import br.com.devspraticar.gestao.usuario.controllers.dto.NotificationErrorDTO;
import br.com.devspraticar.gestao.usuario.controllers.dto.UserRequestDTO;
import br.com.devspraticar.gestao.usuario.controllers.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
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
            }
        ),
        @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
            content = { @Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = NotificationErrorDTO.class))
            }
        ),
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = {@Content(schema = @Schema)}
        )
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDTO> createPreRegistry(@RequestBody UserRequestDTO body);

}
