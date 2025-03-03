package br.com.devspraticar.gestaousuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestaoUsuarioApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoUsuarioApiApplication.class, args);
	}

}
