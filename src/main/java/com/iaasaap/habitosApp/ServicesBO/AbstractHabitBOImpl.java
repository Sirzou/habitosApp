package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.AbstractHabitRepository;
import com.iaasaap.habitosApp.habits.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbstractHabitBOImpl implements AbstractHabitBO {
    @Autowired
    AbstractHabitRepository abstractHabitRepository;

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
    public void setAbstractHabitLevels(String habitId, List<Level> levels) {
        AbstractHabit abstractHabit = abstractHabitRepository.findById(Long.parseLong(habitId)).get();

        abstractHabit.setLevels(levels);
        System.out.println(abstractHabit);
        abstractHabitRepository.save(abstractHabit);
    }
}
