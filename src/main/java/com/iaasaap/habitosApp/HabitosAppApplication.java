package com.iaasaap.habitosApp;

import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.AbstractHabitRepository;
import com.iaasaap.habitosApp.habits.Level;
import com.iaasaap.habitosApp.habits.LevelRepository;
import com.iaasaap.habitosApp.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableNeo4jRepositories
public class HabitosAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitosAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AbstractHabitRepository habitRepository, UserRepository userRepository, LevelRepository levelRepository) {
        return args -> {
            List<Level> levels = new ArrayList<Level>();

            Level l1 = new Level("1","uno",true);
            Level l3 = new Level("3","tres",true);
            Level l5 = new Level("5","cinco",true);
            levels.add(l1);
            levels.add(l3);levels.add(l5);
            //System.out.println(levelRepository.getBasicHabitLevels());
            //levelRepository.getBasicHabitLevels();

            levelRepository.deleteAll();

            levelRepository.save(l1);
            levelRepository.save(l3);
            levelRepository.save(l5);




            AbstractHabit ah = new AbstractHabit("Early woke", "Wake up early", Long.parseLong("1"));
            habitRepository.save(ah);




            ah.setLevels(levels);
            habitRepository.save(ah);
            System.out.println(ah);
            System.out.println(ah.getLevels());

        };
    }
}
