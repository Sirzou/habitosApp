package com.iaasaap.habitosApp.RESTservices;

import com.iaasaap.habitosApp.ServicesBO.ScheduleBO;
import com.iaasaap.habitosApp.habits.schedules.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleService {

    @Autowired
    ScheduleBO scheduleBO;

    @GetMapping(Constants.GET_SCHEDULES)
    public List<Schedule> getSchedules() {
        return scheduleBO.getAllSchedules();
    }

    @GetMapping(Constants.GET_SCHEDULE)
    public Schedule getSchedule(@PathVariable String scheduleId) {
        return scheduleBO.getSchedule(scheduleId);
    }

    @PostMapping(Constants.GET_SCHEDULES)
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleBO.createSchedule(schedule);
    }

    @PutMapping(Constants.GET_SCHEDULE)
    public Schedule updateSchedule(@PathVariable String scheduleId, @RequestBody Schedule schedule) {
        return scheduleBO.updateSchedule(scheduleId, schedule);
    }

    @DeleteMapping(Constants.GET_SCHEDULE)
    public void deleteSchedule(@PathVariable String scheduleId) {
        scheduleBO.deleteSchedule(scheduleId);
    }
}
