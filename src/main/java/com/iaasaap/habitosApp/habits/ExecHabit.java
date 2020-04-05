package com.iaasaap.habitosApp.habits;

import lombok.Getter;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Getter
public class ExecHabit {
    @Id@GeneratedValue
    private Long id;
    @Property(name = "creation")
    private String habitCreation;
    @Property(name = "ownerId")
    private Long ownerId;
    @Property(name = "habitName")
    private String habitName;
    @Property(name = "description")
    private String description;
    @Relationship(type = "LEVEL", direction = Relationship.UNDIRECTED)
    private List<Level> levels;
    @Relationship(type = "SCHEDULE")
    private Schedule schedule;
    @Relationship(type = "PARENT")
    private SketchHabit parentHabit;

    public ExecHabit(SketchHabit sketchHabit){
        this.habitCreation = LocalDateTime.now().toString();
        if (sketchHabit != null && sketchHabit.getLevels() != null){
            this.levels = new ArrayList<>();
            sketchHabit.getLevels().stream()
                    .forEach(x -> this.levels.add(
                            new Level(x.getName(), x.getDescription(), true)));
        }
        this.parentHabit = sketchHabit;
        this.habitName = sketchHabit.getHabitName();
        this.description = sketchHabit.getDescription();
        System.out.println(this);
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }


}
