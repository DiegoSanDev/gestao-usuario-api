package br.com.devspraticar.gestaousuario.rest.api;

import br.com.devspraticar.gestaousuario.dto.request.UserPutRequestDto;
import br.com.devspraticar.gestaousuario.dto.request.UserRequestDto;
import br.com.devspraticar.gestaousuario.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "User API", description = "Operações relacionadas ao gerenciamento de usuários")
public interface UserApi {

    @Operation(
        summary = "Criar um novo usuário",
        description = "Cria um novo usuário com os dados informados.",
        responses = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content)
        }
    )
    ResponseEntity<UserResponseDto> create(
        @Parameter(description = "Dados para criação do usuário", required = true)
        UserRequestDto userRequestDto
    );

    @Operation(
        summary = "Atualizar um usuário existente",
        description = "Atualiza os dados de um usuário com o ID informado.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content)
        }
    )
    ResponseEntity<UserResponseDto> update(
        @Parameter(description = "Dados para atualização do usuário", required = true)
        UserPutRequestDto userRequestDto, Long id
    );

    @Operation(
        summary = "Buscar usuário por ID",
        description = "Retorna os dados de um usuário com base no ID informado.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content)
        }
    )
    ResponseEntity<UserResponseDto> findId(
        @Parameter(description = "ID do usuário", required = true, example = "1")
        Long id
    );

}