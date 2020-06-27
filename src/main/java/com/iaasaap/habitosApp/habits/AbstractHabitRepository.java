package com.iaasaap.habitosApp.habits;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

public interface AbstractHabitRepository extends CrudRepository<AbstractHabit, Long> {

    @Query("MATCH (a:AbstractHabit)-[r]->(l:Level) return a, l;")
    Iterable<AbstractHabit> getAllHabitsWithLevels();
}