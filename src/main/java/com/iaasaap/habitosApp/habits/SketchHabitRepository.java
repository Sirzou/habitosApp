package com.iaasaap.habitosApp.habits;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SketchHabitRepository extends CrudRepository<SketchHabit, Long> {
    @Override
    Iterable<SketchHabit> findAll();

    @Override
    Optional<SketchHabit> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Override
    long count();
}
