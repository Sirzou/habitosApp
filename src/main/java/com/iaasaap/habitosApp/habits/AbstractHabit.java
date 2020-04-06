package com.iaasaap.habitosApp.habits;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.*;

@NodeEntity
@Getter
@Setter
public class AbstractHabit extends Habit{

    public AbstractHabit(String name, String description) {
        super(name, description);
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
        return this.habitName + " - " + this.description + " - " + this.levels;
    }
}
