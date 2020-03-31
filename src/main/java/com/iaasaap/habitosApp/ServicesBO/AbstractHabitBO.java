package com.iaasaap.habitosApp.ServicesBO;

        import com.iaasaap.habitosApp.habits.AbstractHabit;

        import java.util.List;

public interface AbstractHabitBO {
    AbstractHabit createAbstractHabit(AbstractHabit abstractHabit);
    List<AbstractHabit>getAllAbstractHabits();
    AbstractHabit getAbstractHabit(String abstractHabitId);
    void deleteAbstractHabit(String habitId);
    void setAbstractHabitLevels(String habitId,String one, String two, String thr, String fou, String fiv);
}
