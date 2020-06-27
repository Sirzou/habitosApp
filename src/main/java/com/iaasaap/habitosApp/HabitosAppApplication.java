package com.iaasaap.habitosApp;

import com.iaasaap.habitosApp.habits.*;
import com.iaasaap.habitosApp.users.User;
import com.iaasaap.habitosApp.users.UserRepository;
import lombok.Data;
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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableSwagger2
public class HabitosAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitosAppApplication.class, args);
    }

    //@Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            userRepository.findAll().forEach(x -> System.out.println(x));
        };
    }

    @Bean
    public CommandLineRunner demo2(UserRepository userRepository, AbstractHabitRepository abstractHabitRepository, LevelRepository levelRepository, SketchHabitRepository sketchHabitRepository) {
        return args -> {

            // Usuario u1 se registra, pone sus datos
            User u0 = new User("Mario Martínez", "1993-07-07");
            User adminUser = userRepository.save(u0);

            //El pool de habitos ya existe
            AbstractHabit abstractHabit = new AbstractHabit(
                    "leer",
                    "Leer constantemente, puede ser lúdico o educativo",
                    adminUser);
            List<Level> levels = new ArrayList<>();
            levels.add(new Level("1", "leer 5 mins", true));
            levels.add(new Level("3", "leer 15 mins", true));
            levels.add(new Level("5", "leer 35 mins", true));
            levels.forEach(level -> levelRepository.save(level));
            abstractHabit.setLevels(levels);
            SketchHabit sketchHabit = new SketchHabit(abstractHabit);
            AbstractHabit savedAbstractHabit = abstractHabitRepository.save(abstractHabit);

            // Usuario u1 se registra, pone sus datos
            User u1 = new User("Mario Martínez", "1993-07-07");
            User savedUdser = userRepository.save(u1);
            // TODO Set user preferences, like beng a morning habits person
            // u1 encuentra desde el pool de habitos abstractos un habito que le interesa y lo copia para hacerlo suyo en sketch
            //sketchHabitRepository.findAllByOwner(Arrays.asList(savedUdser.getId()));
            savedAbstractHabit.setOwner(savedUdser);
            //savedUdser.setSketchFromAbstractHabit(savedAbstractHabit);
            userRepository.save(savedUdser);
            // u1 ya tiene el hábito en sketch y lo modifica sus levels a unos que le convengan más

            List<Level> newLevels = new ArrayList<>();
            newLevels.add(new Level("1", "leer 3 mins", true));
            newLevels.add(new Level("3", "leer 10 mins", true));
            newLevels.add(new Level("5", "leer 25 mins", true));

            //u1.setExecFromSketchHabit(u1.getSketchedHabits().get(0));
            sketchHabitRepository.findAllByOwner(Arrays.asList(savedUdser.getId()));
            SketchHabit editedSketchHabit = new SketchHabit();
            editedSketchHabit.setLevels(newLevels);

            userRepository.save(savedUdser);



            // TODO find one level by user, by habit and change it.
            // u1 tiene listo su sketch y activa el mecanismo para generar un exec.
            // TODO find one sketch and generate an exec based on time restrains.

            Scanner sc = new Scanner(System.in);
            sc.next();

            //Borramos los habitos creados
            abstractHabit.getLevels().forEach(level -> levelRepository.delete(level));
            abstractHabitRepository.delete(savedAbstractHabit);
            //Borramos los niveles creados
            sketchHabitRepository.findAllByOwner(Arrays.asList(savedUdser.getId()))
                    .forEach(habito -> {
                        habito.getLevels().forEach(level -> levelRepository.delete(level));
                        sketchHabitRepository.delete(habito);
                    });

            //Borramos los usuarios creados
            userRepository.delete(savedUdser);
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
@Data
class Sprite{
    int x,y, width, height;
}
//200621000423