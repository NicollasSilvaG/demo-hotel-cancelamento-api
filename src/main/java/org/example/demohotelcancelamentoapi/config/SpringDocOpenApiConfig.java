package org.example.demohotelcancelamentoapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("REST API - Cancelamento de Reserva")
                .description("API para cancelamento de reserva de hotéis")
                .version("V1")
        );
    }
}
