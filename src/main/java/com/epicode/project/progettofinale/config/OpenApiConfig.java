package com.epicode.project.progettofinale.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Epic Energy Service",
                description = "" +
                        "Spring-Boot application that simulates a CRM system for a company",
                contact = @Contact(
                        name = "JCTS",
                        url = "https://github.com/JacopoColleluori?tab=repositories",
                        email = "jacolle99@gmail.com"
                ),
                license = @License(
                        name = "MIT Licence",
                        url = "https://github.com/JacopoColleluori/BE_Settimana_11/blob/main/LICENSE")),
        servers = @Server(url = "http://localhost:8080")
)


@SecurityScheme(
        name="bearerAuth",
        type= SecuritySchemeType.HTTP,
        bearerFormat="JWT",
        scheme="bearer"
)
public class OpenApiConfig{
}