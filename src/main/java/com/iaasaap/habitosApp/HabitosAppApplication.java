package com.iaasaap.habitosApp;

import com.iaasaap.habitosApp.habits.AbstractHabitRepository;
import com.iaasaap.habitosApp.habits.SketchHabitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class HabitosAppApplication {

    public static void main(String[] args) {
        SpringApplication.  run(HabitosAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AbstractHabitRepository abstractHabitRepository, SketchHabitRepository sketchHabitRepository) {
        return args -> {
        };
    }
}
