package com.iaasaap.habitosApp.habits;

import com.iaasaap.habitosApp.users.User;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Getter
@Setter
public class AbstractHabit extends Habit {

    public AbstractHabit(String name, String description, User owner) {
        super(name, description, owner);
    }

    public String toString() {
        return this.habitName + " - " + this.description + " - " + this.levels;
    }
}
