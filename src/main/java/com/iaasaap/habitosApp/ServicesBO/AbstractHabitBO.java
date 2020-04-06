package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.Level;

import java.util.List;

public interface AbstractHabitBO {
    AbstractHabit createAbstractHabit(AbstractHabit abstractHabit);

    List<AbstractHabit> getAllAbstractHabits();

    AbstractHabit getAbstractHabit(String abstractHabitId);

    void deleteAbstractHabit(String habitId);

    void setAbstractHabitLevels(String habitId, List<Level> levels);
}
