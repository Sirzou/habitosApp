package com.iaasaap.habitosApp.RESTservices;

import com.iaasaap.habitosApp.ServicesBO.AbstractHabitBO;
import com.iaasaap.habitosApp.ServicesBO.ExecHabitBO;
import com.iaasaap.habitosApp.ServicesBO.SketchHabitBO;
import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.ExecHabit;
import com.iaasaap.habitosApp.habits.Level;
import com.iaasaap.habitosApp.habits.SketchHabit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitService {

    @Autowired
    AbstractHabitBO abstractHabitBO;
    @Autowired
    SketchHabitBO sketchHabitBO;
    @Autowired
    ExecHabitBO execHabitBO;

    @GetMapping(Constants.GET_ABSTRACT_HABITS)
    List<AbstractHabit> getAbstractHabits() {
        return abstractHabitBO.getAllAbstractHabits();
    }

    @GetMapping(Constants.GET_ABSTRACT_HABIT)
    public AbstractHabit getAbstractHabit(@PathVariable String habitId) {
        return abstractHabitBO.getAbstractHabit(habitId);
    }

    @PostMapping(Constants.GET_ABSTRACT_HABITS)
    @ResponseBody
    public AbstractHabit createHabit(@RequestBody AbstractHabit abstractHabit) {
        return abstractHabitBO.createAbstractHabit(abstractHabit);
    }

    @PutMapping(Constants.SET_ABSTRACT_LEVELS)
    public AbstractHabit setAbstractHabitLevels(@PathVariable String id, @RequestBody List<Level> levels) {
        abstractHabitBO.setAbstractHabitLevels(id, levels);
        return null;
    }

    @DeleteMapping(Constants.GET_ABSTRACT_HABIT)
    public void deleteAbstractHabit(@PathVariable String habitId) {
        abstractHabitBO.deleteAbstractHabit(habitId);
    }


    @GetMapping(Constants.GET_SKETCH_HABITS)
    List<SketchHabit> getSketchHabits() {
        return sketchHabitBO.getAllSketchHabits();
    }

    @GetMapping(Constants.GET_SKETCH_HABIT)
    SketchHabit getSketchHabits(@PathVariable String id) {
        return sketchHabitBO.getSketchHabit(id);
    }

    @PostMapping(Constants.GET_SKETCH_HABITS)
    SketchHabit createSketchHabit(@RequestBody SketchHabit sketchHabit) {
        return sketchHabitBO.createSketchHabit(sketchHabit);
    }

    @PostMapping(Constants.CREATE_SKETCH_HABIT_FROM_ABSTRACT)
    SketchHabit createSketchHabit(@PathVariable String abstractHabitId) {
        return sketchHabitBO.createSketchHabitFromAbstract(abstractHabitId);
    }

    @PostMapping(Constants.SET_SKETCH_LEVELS)
    public void setSketchHabitLevels(@PathVariable String habitId, @RequestBody List<Level> levels) {
        sketchHabitBO.setSketchHabitLevels(habitId, levels);
    }

    @DeleteMapping(Constants.GET_SKETCH_HABIT)
    public void deleteSketchHabit(@PathVariable String habitId) {
        sketchHabitBO.deleteSketchHabit(habitId);
    }

    @GetMapping(Constants.GET_EXEC_HABIT)
    public ExecHabit getExecHabit(@PathVariable String habitId) {
        return execHabitBO.getExecHabit(habitId);
    }

    @PostMapping(Constants.CREATE_EXEC_HABIT_FROM_SKETCH)
    public ExecHabit createExecHabitFromSketch(@PathVariable String sketchHabitId) {
        return execHabitBO.createExecHabit(sketchHabitId);
    }

    @PutMapping(Constants.EDIT_EXEC_HABIT)
    public ExecHabit editExecHabit(@RequestBody ExecHabit execHabit) {
        return execHabitBO.updateHabit(execHabit);
    }

    @DeleteMapping(Constants.GET_EXEC_HABIT)
    public void deleteExecHabit(@PathVariable String habitId) {
        execHabitBO.delete(habitId);
    }
}
