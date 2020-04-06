package com.iaasaap.habitosApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableSwagger2
public class HabitosAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitosAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            // Usuario u1 se registra, pone sus datos y escribe sus preferenci as.
            // u1 encuentra desde el pool de habitos abstractos un habito que le interesa y lo copia para hacerlo suyo en sketch
            // u1 ya tiene el hábito en sketch y lo modifica sus levels a unos que le convengan más
            // u1 tiene listo su sketch y activa el mecanismo para generar un exec.
        };
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
