package ru.nemcov.coffee_maker.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Дмитрий Немцов",
                        email = "nemcov@nemcov.ru"
                ),
                description = "Документация для работы с кофеваркой",
                title = "Кофе-машина - Спецификация",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Локальный сервер",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
