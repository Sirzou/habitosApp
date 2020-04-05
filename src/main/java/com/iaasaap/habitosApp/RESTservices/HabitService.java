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

    @GetMapping("/abstractHabits")
    List<AbstractHabit> getAbstractHabits() {
        return abstractHabitBO.getAllAbstractHabits();
    }

    @GetMapping("/abstractHabits/{id}")
    public AbstractHabit getAbstractHabit(@PathVariable String id) {
        return abstractHabitBO.getAbstractHabit(id);
    }

    @PostMapping("/createAbstractHabit")
    @ResponseBody
    public AbstractHabit createHabit(@RequestBody AbstractHabit abstractHabit) {
        return abstractHabitBO.createAbstractHabit(abstractHabit);
    }

    @PutMapping("/setHabitLevels/{id}")
    public AbstractHabit setAbstractHabitLevels(@PathVariable String id, @RequestBody List<Level> levels) {
        //levels.stream().forEach(x -> System.out.println(x));
        abstractHabitBO.setAbstractHabitLevels(id, levels);
        return null;
    }

    @DeleteMapping("/abstractHabit/{id}")
    public void deleteAbstractHabit(@PathVariable String id) {
        abstractHabitBO.deleteAbstractHabit(id);
    }


    @GetMapping("/sketchHabits")
    List<SketchHabit> getSketchHabits() {
        return sketchHabitBO.getAllSketchHabits();
    }

    @GetMapping("/sketchHabits/{id}")
    SketchHabit getSketchHabits(@PathVariable String id) {
        return sketchHabitBO.getSketchHabit(id);
    }

    @PostMapping("/createSketchHabit/")
    SketchHabit createSketchHabit(@RequestBody SketchHabit sketchHabit) {
        return sketchHabitBO.createSketchHabit(sketchHabit);
    }

    @PostMapping("/createSketchHabit/{id}")
    SketchHabit createSketchHabit(@PathVariable String id) {
        return sketchHabitBO.createSketchHabitFromAbstract(id);
    }

    @PostMapping("/setHabitLevels/{id}")
    public void setSketchHabitLevels(@PathVariable String id, @RequestBody List<Level> levels) {
        sketchHabitBO.setSketchHabitLevels(id, levels);
    }

    @DeleteMapping("/sketchHabit/{id}")
    public void deleteSketchHabit(@PathVariable String habitId) {
        sketchHabitBO.deleteSketchHabit(habitId);
    }


    @GetMapping("/execHabits/{id}")
    public ExecHabit getExecHabits(@PathVariable String id) {
        return execHabitBO.getExecHabit(id);
    }

    @PostMapping("/createExecHabit/{sketchHabitId}")
    public ExecHabit createExecHabit(@PathVariable String sketchHabitId) {
        return execHabitBO.createExecHabit(sketchHabitId);
    }
    @PutMapping("editExecHabit/{id}/")
    public ExecHabit editExecHabit(@RequestBody ExecHabit execHabit){
        return execHabitBO.updateHabit(execHabit);
    }

    @DeleteMapping("/execHabit/{id}/")
    public void deleteExecHabit(@PathVariable String id) {
        execHabitBO.delete(id);
    }
}
