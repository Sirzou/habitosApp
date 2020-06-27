package com.iaasaap.habitosApp.ServicesBO;

import com.iaasaap.habitosApp.habits.schedules.Schedule;
import com.iaasaap.habitosApp.habits.schedules.ScheduleRepository;
import com.iaasaap.habitosApp.habits.schedules.SortDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleBOImpl implements ScheduleBO {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @Override
    public Schedule getSchedule(String scheduleId) {
        return scheduleRepository.findById(Long.parseLong(scheduleId)).get();
    }

    @Override
    public Schedule updateSchedule(String scheduleId, Schedule newSchedule) {
        Schedule savedSchedule = scheduleRepository.findById(Long.parseLong(scheduleId)).get();
        editSchedule(newSchedule, savedSchedule);
        return scheduleRepository.save(savedSchedule);
    }

    public void editSchedule(Schedule originSchedule, Schedule destinySchedule) {
        if (originSchedule != null) {
            if (originSchedule.getAntelacion() != null) {
                destinySchedule.setAntelacion(originSchedule.getAntelacion());
            }
            if (originSchedule.getDefaultTime() != null) {
                destinySchedule.setDefaultTime(originSchedule.getDefaultTime());
            }
            if (originSchedule.getScheduleType() != null) {
                destinySchedule.setScheduleType(originSchedule.getScheduleType());
            }
            if (originSchedule.getSortDays() != null) {
                if (destinySchedule.getSortDays() == null) {
                    destinySchedule.setSortDays(new ArrayList<SortDay>());
                }
                Schedule finalDestinySchedule = destinySchedule;
                originSchedule.getSortDays().stream().forEach(x -> finalDestinySchedule.getSortDays().add(x));
            }
        }
    }

    @Override
    public void deleteSchedule(String scheduleId) {
        scheduleRepository.deleteById(Long.parseLong(scheduleId));
    }
}
