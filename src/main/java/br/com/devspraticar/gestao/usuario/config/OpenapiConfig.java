package br.com.devspraticar.gestao.usuario.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenapiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("API - Gestão de Usuários")
                .description("API para gerenciamento de cadastro de usuários. " +
                        "Esta API possibilita a criação, busca e atualização de informações dos usuários.")
                .version("v0.0.1")
                .contact(new Contact().name("Diego Santos").email("diegosan.dev@gmail.com")))
            .servers(List.of(new Server().url("https://devspraticar.com.br/v1")));
    }

}
