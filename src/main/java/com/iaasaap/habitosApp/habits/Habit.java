package com.iaasaap.habitosApp.habits;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NodeEntity
public class Habit {
    @Id
    @GeneratedValue
    protected Long id;
    @Property(name = "creation")
    protected String habitCreation;
    @Property(name = "ownerId")
    private Long ownerId;
    @Property(name = "habitName")
    protected String habitName;
    @Property(name = "description")
    protected String description;
    @Relationship(type = "LEVEL", direction = Relationship.UNDIRECTED)
    protected List<Level> levels;

    protected Habit(String name, String description) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
        this.ownerId = Long.parseLong("1");
    }

    protected Habit() {
        this.habitCreation = LocalDateTime.now().toString();
    }

    public void copyFromHabit(Habit habit) {
        this.habitCreation = LocalDateTime.now().toString();
        if (habit != null && habit.getLevels() != null) {
            this.levels = new ArrayList<>();
            habit.getLevels().stream()
                    .forEach(x -> this.levels.add(
                            new Level(x.getName(), x.getDescription(), true)));
            this.habitName = habit.getHabitName();
            this.description = habit.getDescription();
        }
    }

    public String getHabitName() {
        return habitName;
    }

    public String getDescription() {
        return description;
    }

    public List<Level> getLevels() {
        return levels;
    }
}
