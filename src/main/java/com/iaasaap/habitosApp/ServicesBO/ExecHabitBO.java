package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.ExecHabit;
import com.iaasaap.habitosApp.habits.Level;

import java.util.List;

public interface ExecHabitBO {

    ExecHabit createExecHabit(String execHabitId);

    ExecHabit getExecHabit(String habitId);

    void delete(String hjabitId);

    ExecHabit updateHabit(ExecHabit execHabit);

    void setExecHabitLevels(String habitId, List<Level> levels);
}
