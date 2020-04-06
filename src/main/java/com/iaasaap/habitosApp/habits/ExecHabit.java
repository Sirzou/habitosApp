package com.iaasaap.habitosApp.habits;

import lombok.Data;
import lombok.Getter;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Getter
@Data
public class ExecHabit extends Habit{

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
    private SketchHabit parentHabit;


    public ExecHabit(SketchHabit sketchHabit){
        super();
        super.copyFromHabit(sketchHabit);

        if (sketchHabit != null && sketchHabit.getLevels() != null){
            this.levels = new ArrayList<>();
            sketchHabit.getLevels().stream()
                    .forEach(x -> this.levels.add(
                            new Level(x.getName(), x.getDescription(), true)));
        }
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
}
