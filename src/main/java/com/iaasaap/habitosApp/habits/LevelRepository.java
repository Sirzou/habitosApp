package com.iaasaap.habitosApp.habits;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

public interface LevelRepository extends CrudRepository<Level, Long> {

    @Query("MATCH (l:Level) WHERE l.name='3' OR l.name='1' OR l.name='5' RETURN l;")
    Iterable<Level> getBasicHabitLevels();

}
