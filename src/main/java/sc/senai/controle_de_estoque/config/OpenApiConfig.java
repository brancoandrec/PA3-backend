package sc.senai.controle_de_estoque.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(
                new Info()
                        .title("Gerenciamento de estoque")
                        .description("API de Gerenciamento de estoque")
                        .version("1.0.0")
        );
    }
}