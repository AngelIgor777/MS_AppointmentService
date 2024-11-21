package org.clinic.ms_appointmentservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Record System Api",
                description = "Api ситемы записи к врачам на прием",
                version = "1.0.0",
                contact = @Contact(
                        name = "Alexeev Serghei",
                        email = "stesak2022@gmail.com",
                        url = ""
                )
        )
)
public class OpenApiConfig {
}
