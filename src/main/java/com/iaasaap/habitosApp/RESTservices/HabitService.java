package com.iaasaap.habitosApp.RESTservices;

import com.iaasaap.habitosApp.ServicesBO.AbstractHabitBO;
import com.iaasaap.habitosApp.habits.AbstractHabit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitService {

    @Autowired
    AbstractHabitBO abstractHabitBO;

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
        System.out.println(abstractHabit);
        System.out.println(abstractHabit.getLevels());
        return abstractHabitBO.createAbstractHabit(abstractHabit);
    }

    @DeleteMapping("/abstractHabit/{id}")
    public void deleteAbstractHabit(@PathVariable String id){
        abstractHabitBO.deleteAbstractHabit(id);
    }
}
