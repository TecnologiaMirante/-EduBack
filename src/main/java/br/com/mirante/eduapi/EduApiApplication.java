package br.com.mirante.eduapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}", version = "${info.build.version}", description = "${info.app.description}",
        contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Time Mirante", email = "contato@mirante.com.br")))
@SecurityScheme(
        name = "bearer-key",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@ComponentScan("br.com.mirante")
@SpringBootApplication
public class EduApiApplication {
    public static void main(String[] args) {SpringApplication.run(EduApiApplication.class, args);}

}
