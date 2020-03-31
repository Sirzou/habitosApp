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

    @PutMapping("/setHabitLevels/{id}")
    public AbstractHabit setHabitLevels(@PathVariable String id,
                                        @RequestParam("1") String one,
                                        @RequestParam("2") String two,
                                        @RequestParam("3") String thr,
                                        @RequestParam("4") String fou,
                                        @RequestParam("5") String fiv) {
        System.out.println("" + id + one + two + thr + fou + fiv);
        abstractHabitBO.setAbstractHabitLevels(id, one, two, thr, fou, fiv);
        System.out.println("habtId: " + id);
        return null;
    }

    @DeleteMapping("/abstractHabit/{id}")
    public void deleteAbstractHabit(@PathVariable String id) {
        abstractHabitBO.deleteAbstractHabit(id);
    }
}
