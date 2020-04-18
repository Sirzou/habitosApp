package com.iaasaap.habitosApp.habits;

import com.iaasaap.habitosApp.habits.schedules.Schedule;
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
public class SketchHabit extends Habit {

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Property
    private boolean isOn;
    @Relationship(type = "PARENT")
    private AbstractHabit parentHabit;
    @Relationship(type = "SCHEDULE")
    private Schedule schedule;

    public SketchHabit(AbstractHabit abstractHabit) {
        super();
        this.parentHabit = abstractHabit;
        copyFromHabit(abstractHabit);
        isOn = false;
    }

    public void setParentHabit(AbstractHabit parentHabit) {
        this.parentHabit = parentHabit;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public AbstractHabit getParentHabit() {
        return this.parentHabit;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public SketchHabit(String name, String description) {
        super(name, description);
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
}
