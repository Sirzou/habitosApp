package com.iaasaap.habitosApp.habits;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@NodeEntity
@Getter
@Setter
public class AbstractHabit {
    @Id
    @GeneratedValue
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


    public AbstractHabit(String name, String description, Long ownerId) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
        this.ownerId = ownerId;
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

    public String toString() {
        return this.habitName + " - " + this.description + " - from user " + this.ownerId + " - " + this.levels;
    }
}
