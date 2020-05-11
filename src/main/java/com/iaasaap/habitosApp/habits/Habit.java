package com.iaasaap.habitosApp.habits;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Getter;

@Getter
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

    protected Habit(final String name, final String description) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
        this.ownerId = Long.parseLong("1");
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
        this.levels = new ArrayList<>();
        levels.stream()
                .forEach(x -> this.levels.add(
                        new Level(x.getName(), x.getDescription(), true)));
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
