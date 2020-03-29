package com.iaasaap.habitosApp;

import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.AbstractHabitRepository;
import com.iaasaap.habitosApp.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableNeo4jRepositories
public class HabitosAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitosAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AbstractHabitRepository habitRepository, UserRepository userRepository) {
        return args -> {
            Map<String, String> levels = new HashMap<String,String>();

            levels.put("1", "uno");
            levels.put("2", "dos");
            levels.put("3", "tres");
            AbstractHabit ah = new AbstractHabit("Early woke", "Wake up early", Long.parseLong("1"), levels);
            System.out.println(ah);
            System.out.println(ah.getLevels());

        };
    }
}
