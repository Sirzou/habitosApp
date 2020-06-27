package com.iaasaap.habitosApp.habits;

import com.iaasaap.habitosApp.habits.schedules.Schedule;
import com.iaasaap.habitosApp.users.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Setter
@Getter
@Data
@NoArgsConstructor
public class SketchHabit extends Habit {
    @Property
    private boolean on;
    @Relationship(type = "PARENT")
    private AbstractHabit parentHabit;
    @Relationship(type = "SCHEDULE")
    private Schedule schedule;

    public SketchHabit(AbstractHabit abstractHabit) {
        super();
        this.parentHabit = abstractHabit;
        copyFromHabit(abstractHabit);
        on = false;
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

    public SketchHabit(String name, String description, User owner) {
        super(name, description, owner);
    }
}
