package com.iaasaap.habitosApp.habits;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    @Override
    Schedule save(Schedule schedule);

    @Override
    Optional<Schedule> findById(Long aLong);

    @Override
    Iterable<Schedule> findAll();

    @Override
    void deleteById(Long aLong);
}
