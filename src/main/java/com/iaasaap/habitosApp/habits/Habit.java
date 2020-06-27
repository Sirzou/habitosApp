package com.iaasaap.habitosApp.habits;

import com.iaasaap.habitosApp.users.User;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NodeEntity
public class Habit {
    @Id
    @GeneratedValue
    protected Long id;
    @Property(name = "creation")
    protected String habitCreation;
    @Property(name = "habitName")
    protected String habitName;
    @Property(name = "description")
    protected String description;
    @Relationship(type = "LEVEL", direction = Relationship.UNDIRECTED)
    protected List<Level> levels;
    @Relationship(type = "OWNER")
    private User owner;

    protected Habit(final String name, final String description, User owner) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
        this.owner = owner;
    }

    protected Habit() {
        this.habitCreation = LocalDateTime.now().toString();
    }

    public void copyFromHabit(final Habit habit) {
        this.habitCreation = LocalDateTime.now().toString();
        if (habit != null && habit.getLevels() != null) {
            setLevels(habit.getLevels());
            this.habitName = habit.getHabitName();
            this.description = habit.getDescription();
        }
    }

    public void setLevels(final List<Level> levels) {
        this.levels = levels.stream()
                .map(level -> new Level(level.getName(), level.getDescription(), true))
                .collect(Collectors.toList());
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
