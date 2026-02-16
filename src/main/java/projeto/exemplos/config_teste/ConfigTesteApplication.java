package projeto.exemplos.config_teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import projeto.exemplos.config_teste.infra.config.JwtConfig;

@SpringBootApplication
public class ConfigTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigTesteApplication.class, args);
	}

}
