package com.iaasaap.habitosApp.habits;

import org.springframework.data.repository.CrudRepository;

public interface SketchHabitRepository extends CrudRepository<SketchHabit, Long> {

    Iterable<SketchHabit> findAllByOwner(Iterable<Long> longs);
}
