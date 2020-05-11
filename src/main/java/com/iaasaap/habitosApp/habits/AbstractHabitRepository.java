package com.iaasaap.habitosApp.habits;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface AbstractHabitRepository extends CrudRepository<AbstractHabit, Long> {
    @Override
    Optional<AbstractHabit> findById(Long habitId);

    @Override
    List<AbstractHabit> findAll();

    @Override
    long count();

    @Override
    void deleteById(Long habitId);

    @Query("MATCH (a:AbstractHabit)-[r]->(l:Level) return a, l;")
    List<AbstractHabit> getAllHabitsWithLevels();
}