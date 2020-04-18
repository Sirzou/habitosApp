package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.schedules.Schedule;

import java.util.List;

public interface ScheduleBO {
    Schedule createSchedule(Schedule schedule);

    Schedule getSchedule(String scheduleId);

    List<Schedule> getAllSchedules();

    Schedule updateSchedule(String scheduleId, Schedule newSchedule);

    void deleteSchedule(String scheduleId);

}
