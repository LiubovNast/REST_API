package com.nastoiashcha.rest_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {


    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("REST API")
                        .description("This is a sample REST API server created using springdocs - " +
                                "a library for OpenAPI 3 with spring boot.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
