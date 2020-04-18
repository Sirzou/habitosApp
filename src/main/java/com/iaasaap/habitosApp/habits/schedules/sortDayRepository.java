package com.iaasaap.habitosApp.habits.schedules;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface sortDayRepository extends CrudRepository<SortDay, Long> {
    @Override
    SortDay save(SortDay sortDay);

    @Override
    Optional<SortDay> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
