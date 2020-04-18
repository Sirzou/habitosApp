package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.Level;
import com.iaasaap.habitosApp.habits.SketchHabit;

import java.util.List;

public interface SketchHabitBO {
    SketchHabit createSketchHabit(SketchHabit sketchHabit);

    SketchHabit createSketchHabitFromAbstract(String habitId);

    List<SketchHabit> getAllSketchHabits();

    SketchHabit getSketchHabit(String sketchHabitId);

    SketchHabit udpateSketchHabit(String sketchHabitId, SketchHabit sketchHabit);

    void deleteSketchHabit(String sketchHabitId);

    void setSketchHabitLevels(String habitId, List<Level> levels);
}
