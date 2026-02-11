package br.com.devspraticar.gestaousuario.mapper;

import br.com.devspraticar.gestaousuario.controller.dto.response.AuthTokenResponseDTO;
import br.com.devspraticar.gestaousuario.model.AuthToken;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthMapper {

    public static AuthTokenResponseDTO toResponse(AuthToken authToken) {
        return AuthTokenResponseDTO.builder()
            .accessToken(authToken.getAccessToken())
            .refreshToken(authToken.getRefreshToken())
            .expiresIn(authToken.getExpiresIn())
            .tokenType(authToken.getTokenType())
            .build();
    }

}