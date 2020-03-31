package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.AbstractHabitRepository;
import com.iaasaap.habitosApp.habits.Level;
import com.iaasaap.habitosApp.habits.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AbstractHabitBOImpl implements AbstractHabitBO {
    @Autowired
    AbstractHabitRepository abstractHabitRepository;
    @Autowired
    LevelRepository levelRepository;

    @Override
    public AbstractHabit createAbstractHabit(AbstractHabit abstractHabit) {
        return abstractHabitRepository.save(abstractHabit);
    }

    @Override
    public List<AbstractHabit> getAllAbstractHabits() {
        return abstractHabitRepository.findAll();
    }

    @Override
    public AbstractHabit getAbstractHabit(String habitId) {
        return abstractHabitRepository.findById(Long.parseLong(habitId)).get();
    }

    @Override
    public void deleteAbstractHabit(String habitId) {
        abstractHabitRepository.deleteById(Long.parseLong(habitId));
    }


    @Override
    public void setAbstractHabitLevels(String habitId, String one, String two, String thr, String fou, String fiv) {
        AbstractHabit abstractHabit = abstractHabitRepository.findById(Long.parseLong(habitId)).get();
        List<Level> levels  = new ArrayList<Level>();

        setLevelIfExists(levels,new Level("1", one, true));
        setLevelIfExists(levels,new Level("2", two, true));
        setLevelIfExists(levels,new Level("3", thr, true));
        setLevelIfExists(levels,new Level("4", fou, true));
        setLevelIfExists(levels,new Level("5", fiv, true));

        abstractHabit.setLevels(levels);
        System.out.println(abstractHabit);
        abstractHabitRepository.save(abstractHabit);
    }

    void setLevelIfExists(List<Level> levels,Level level) {
        if (!level.getDescription().equals("")) {
            levels.add(level);
        }
    }
}
