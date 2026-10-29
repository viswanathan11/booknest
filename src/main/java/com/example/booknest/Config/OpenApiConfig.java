package com.example.booknest.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI booknestOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BookNest Library API")
                        .description(
                                "RESTful API for managing library members, books, and borrowing lifecycle."
                        )
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("BookNest Team")
                                .email("support@booknest.com")
                        )
                );
    }
}