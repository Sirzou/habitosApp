package com.iaasaap.habitosApp.habits;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExecHabitRepository extends CrudRepository<ExecHabit,Long> {
    @Override
    ExecHabit save(ExecHabit execHabit);

    @Override
    Iterable<ExecHabit> findAll();

    @Override
    Optional<ExecHabit> findById(Long aLong);

    @Override
    void deleteById(Long aLong);


}
