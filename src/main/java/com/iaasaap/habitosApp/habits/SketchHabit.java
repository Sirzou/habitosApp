package com.iaasaap.habitosApp.habits;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Setter
@Getter
@Data
@NoArgsConstructor
public class SketchHabit {
    @Id
    @GeneratedValue
    private Long id;
    @Property(name = "creation")
    private String habitCreation;
    @Property(name = "habitName")
    private String habitName;
    @Property(name = "description")
    private String description;
    @Relationship(type = "LEVEL", direction = Relationship.UNDIRECTED)
    private List<Level> levels;
    @Relationship(type = "PARENT")
    private AbstractHabit parentHabit;


    public SketchHabit(AbstractHabit abstractHabit) {
        this.habitCreation = LocalDateTime.now().toString();
        if (abstractHabit != null && abstractHabit.getLevels() != null){
            this.levels = new ArrayList<>();
            abstractHabit.getLevels().stream()
                    .forEach(x -> this.levels.add(
                            new Level(x.getName(), x.getDescription(), true)));
        }
        this.parentHabit = abstractHabit;
        this.habitName = abstractHabit.getHabitName();
        this.description = abstractHabit.getDescription();
        System.out.println(this);
    }

    public SketchHabit(String name, String description) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
    }
    public String getHabitName() {
        return this.habitName;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Level> getLevels() {
        return this.levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
}
