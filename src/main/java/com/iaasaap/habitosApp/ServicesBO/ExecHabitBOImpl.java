package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExecHabitBOImpl implements ExecHabitBO {

    @Autowired
    SketchHabitRepository sketchHabitRepository;
    @Autowired
    ExecHabitRepository execHabitRepository;

    @Override
    public ExecHabit createExecHabit(String sketchHabitId) {
        SketchHabit sketchHabit = sketchHabitRepository.findById(Long.parseLong(sketchHabitId)).get();
        ExecHabit execHabit = new ExecHabit(sketchHabit);
        return execHabitRepository.save(execHabit);
    }

    @Override
    public ExecHabit getExecHabit(String habitId) {
        return execHabitRepository.findById(Long.parseLong(habitId)).get();
    }

    @Override
    public void delete(String habitId) {
        execHabitRepository.deleteById(Long.parseLong(habitId));
    }

    @Override
    public ExecHabit updateHabit(ExecHabit execHabit) {
        return execHabitRepository.save(execHabit);
    }

    @Override
    public void setExecHabitLevels(String habitId, List<Level> levels) {
        ExecHabit execHabit = execHabitRepository.findById(Long.parseLong(habitId)).get();
        execHabit.setLevels(levels);
        execHabitRepository.save(execHabit);
    }
}
