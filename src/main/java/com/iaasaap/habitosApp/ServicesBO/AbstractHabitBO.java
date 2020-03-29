package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.AbstractHabit;

import java.util.List;

public interface AbstractHabitBO {
    AbstractHabit createAbstractHabit(AbstractHabit abstractHabit);
    List<AbstractHabit>getAllAbstractHabits();
    AbstractHabit getAbstractHabit(String abstractHabitId);
    void deleteAbstractHabit(String habitId);
}
