package com.example.microservices.order.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI orderServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("order Service API")
                        .description("This is the REST API for order service")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("you can see the order service")
                        .url("https://dummy url"));
    }
}
