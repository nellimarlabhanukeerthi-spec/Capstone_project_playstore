package com.playstore.appms.config;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI appAPI() {
        return new OpenAPI()
                .info(new Info().title("App-MS API")
                        .description("PlayStore App Service")
                        .version("1.0"));
    }
}
