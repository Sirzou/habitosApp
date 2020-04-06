package com.iaasaap.habitosApp.habits;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.List;

@NodeEntity
@Setter
@Getter
@Data
@NoArgsConstructor
public class SketchHabit extends Habit{

    @Relationship(type = "PARENT")
    private AbstractHabit parentHabit;
    @Relationship(type = "SCHEDULE")
    private Schedule schedule;

    public SketchHabit(AbstractHabit abstractHabit) {
        super();
        this.parentHabit = abstractHabit;
        copyFromHabit(abstractHabit);
    }

    public SketchHabit(String name, String description) {
        super(name,description);
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
}
