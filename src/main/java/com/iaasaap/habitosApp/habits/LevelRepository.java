package com.iaasaap.habitosApp.habits;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LevelRepository extends CrudRepository<Level, Long> {
    @Override
    Optional<Level> findById(Long aLong);

    @Override
    Iterable<Level> findAllById(Iterable<Long> iterable);

    @Query("MATCH (l:Level) WHERE l.name='3' OR l.name='1' OR l.name='5' RETURN l;")
    List<Level> getBasicHabitLevels();
}
