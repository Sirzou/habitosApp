package com.iaasaap.habitosApp;

import com.iaasaap.habitosApp.habits.*;
import com.iaasaap.habitosApp.users.User;
import com.iaasaap.habitosApp.users.UserRepository;
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

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableSwagger2
public class HabitosAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitosAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            userRepository.findAll().forEach(x -> System.out.println(x));
        };
    }
    //@Bean
    public CommandLineRunner demo2(UserRepository userRepository, AbstractHabitRepository abstractHabitRepository, LevelRepository levelRepository) {
        return args -> {
            //El pool de habitos ya existe
            AbstractHabit abstractHabit = new AbstractHabit("leer", "Leer constantemente, puede ser lúdico o educativo");
            List<Level> levels = new ArrayList<>();
            levels.add(new Level("1", "leer 5 mins", true));
            levels.add(new Level("3", "leer 15 mins", true));
            levels.add(new Level("5", "leer 35 mins", true));
            abstractHabit.setLevels(levels);
            AbstractHabit savedAbstractHabit = abstractHabitRepository.save(abstractHabit);
            // Usuario u1 se registra, pone sus datos
            User u1 = new User("Mario Martínez", "1993-07-07");
            User savedUdser = userRepository.save(u1);
            // TODO Set user preferences, like beng a morning habits person
            // u1 encuentra desde el pool de habitos abstractos un habito que le interesa y lo copia para hacerlo suyo en sketch
            u1.setSketchFromAbstractHabit(abstractHabit);
            userRepository.save(u1);
            // u1 ya tiene el hábito en sketch y lo modifica sus levels a unos que le convengan más
            // TODO find one level by user, by habit and change it.
            // u1 tiene listo su sketch y activa el mecanismo para generar un exec.
            // TODO find one sketch and generate an exec based on time restrains.

            //Borramos los usuarios creados
            userRepository.delete(savedUdser);
            //Borramos los habitos creados
            abstractHabitRepository.delete(savedAbstractHabit);
            //Borramos los niveles creados
            u1.getSketchedHabits().forEach(habito -> {habito.getLevels().forEach(level -> levelRepository.delete(level));});
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
