package com.example.UserCrudApplication.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Manjul Tamang",
                        email = "manzultamang77@gmail.com"

                ),
                description = "",
                title = "User Crud Application",
                version = "1.0"
        ),
        servers = {

                @Server(
                        description = "DEV ENV",
                        url = "http://localhost:8081"
                )
        }

)
public class SwaggerConfig {
}