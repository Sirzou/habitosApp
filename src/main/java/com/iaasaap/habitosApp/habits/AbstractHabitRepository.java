package com.iaasaap.habitosApp.habits;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbstractHabitRepository extends CrudRepository<AbstractHabit, Long> {

    @Override
    Optional<AbstractHabit> findById(Long habitId);

    @Override
    AbstractHabit save(AbstractHabit abstractHabit);

    @Override
    List<AbstractHabit> findAll();

    @Override
    long count();

    @Override
    void deleteById(Long habitId);
}