package com.iaasaap.habitosApp.habits;

import lombok.AllArgsConstructor;
import lombok.Generated;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NodeEntity
public class Habit {
    @Id
    @GeneratedValue
    private Long habitUUID;
    @Property(name = "habitName")
    private String habitName;
    @Property(name = "habitCreation")
    private String habitCreation;
    @Property(name = "description")
    private String description;
    @Property(name = "levels")
    private Map<String, String> levels;

    public Habit() {
        this.habitCreation = LocalDateTime.now().toString();
    }

    public Habit(String name) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
    }

    public Habit(String name, String description) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
    }


    public Habit(UUID habitID, LocalDateTime habitCreation, String name) {
        this.habitCreation = habitCreation.toString();
        this.habitName = name;
    }

    public Habit(UUID habitID, LocalDateTime habitCreation, String name, String description) {
        this.habitCreation = habitCreation.toString();
        this.habitName = name;
        this.description = description;
    }

    public Long getHabitUUID() {
        return habitUUID;
    }

    public String getHabitName() {
        return habitName;
    }

    public String getHabitCreation() {
        return habitCreation;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getLevels() {
        return levels;
    }

    public void copyHabit(Habit habit) {
        this.habitName = habit.habitName;
        this.description = habit.description;
        this.levels = habit.levels;
    }
    public String toString(){
        return this.habitName  + " - " + this.description + this.levels;
    }
}
