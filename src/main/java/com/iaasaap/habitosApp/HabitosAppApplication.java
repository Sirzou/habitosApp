package com.iaasaap.habitosApp;

import com.iaasaap.habitosApp.habits.AbstractHabitRepository;
import com.iaasaap.habitosApp.habits.SketchHabitRepository;
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
    public CommandLineRunner demo(AbstractHabitRepository abstractHabitRepository, SketchHabitRepository sketchHabitRepository) {
        return args -> {

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
