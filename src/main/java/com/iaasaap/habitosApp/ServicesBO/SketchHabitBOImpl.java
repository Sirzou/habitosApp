package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SketchHabitBOImpl implements SketchHabitBO {

    @Autowired
    SketchHabitRepository sketchHabitRepository;
    @Autowired
    AbstractHabitRepository abstractHabitRepository;

    @Override
    public SketchHabit createSketchHabit(SketchHabit sketchHabit) {
        return sketchHabitRepository.save(sketchHabit);
    }

    @Override
    public SketchHabit createSketchHabitFromAbstract(String habitId) {
        AbstractHabit abstractHabit = abstractHabitRepository.findById(Long.parseLong(habitId)).get();
        SketchHabit sketchHabit = new SketchHabit(abstractHabit);
        return sketchHabitRepository.save(sketchHabit);
    }

    @Override
    public List<SketchHabit> getAllSketchHabits() {
        return (List<SketchHabit>) sketchHabitRepository.findAll();
    }

    @Override
    public SketchHabit getSketchHabit(String sketchHabitId) {
        return sketchHabitRepository.findById(Long.parseLong(sketchHabitId)).get();
    }

    @Override
    public void deleteSketchHabit(String sketchHabitId) {
        sketchHabitRepository.deleteById(Long.parseLong(sketchHabitId));
    }

    @Override
    public void setSketchHabitLevels(String habitId, List<Level> levels) {
        SketchHabit sketchHabit = sketchHabitRepository.findById(Long.parseLong(habitId)).get();
        sketchHabit.setLevels(levels);
        sketchHabitRepository.save(sketchHabit);
    }
}
