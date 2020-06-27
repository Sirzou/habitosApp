package com.iaasaap.habitosApp.habits;

import lombok.Data;
import lombok.Getter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDateTime;

@NodeEntity
@Getter
@Data
public class ExecHabit extends Habit {

    @Property
    private String DoW;
    @Property
    private String levelAchieved;
    @Property
    private LocalDateTime scheduledTS;
    @Property
    private LocalDateTime achievedTS;
    @Property
    private boolean wasAchieved;
    @Property
    private boolean isToDo;
    @Relationship(type = "PARENT")
    private Habit parentHabit;

    public ExecHabit(Habit habit) {
        super();
        this.parentHabit = habit;
        super.copyFromHabit(habit);
        setToDo(true);
    }

    public void updateHabit(ExecHabit execHabit) {
        if (execHabit != null) {
            if (execHabit.getLevels() != null) {
                super.setLevels(execHabit.getLevels());
            }
            if (execHabit.getDoW() != null) {
                this.setDoW(execHabit.getDoW());
            }
            if (execHabit.getScheduledTS() != null) {
                this.setScheduledTS(execHabit.getScheduledTS());
            }
        }
    }

    public void executeHabit(boolean isAchieved, String levelAchieved, LocalDateTime achievedDate) {
        setToDo(false);
        setWasAchieved(isAchieved);
        setLevelAchieved(levelAchieved);
        if (isAchieved) {
            setAchievedTS(LocalDateTime.now());
        } else {
            setAchievedTS(achievedDate);
        }
    }
}