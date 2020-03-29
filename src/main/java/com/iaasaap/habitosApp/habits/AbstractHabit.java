package com.iaasaap.habitosApp.habits;

import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.time.LocalDateTime;
import java.util.Map;

@NodeEntity
@Getter
public class AbstractHabit {
    @Id
    @GeneratedValue
    private Long id;
    @Property(name = "ownerId")
    private Long ownerId;
    @Property(name = "name")
    private String habitName;
    @Property(name = "creation")
    private String habitCreation;
    @Property(name = "description")
    private String description;
    @Property(name = "levels")
    private Map<String, String> levels;

    public AbstractHabit() {
        this.habitCreation = LocalDateTime.now().toString();
        this.ownerId = Long.parseLong("0");
    }

    public AbstractHabit(String name) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
    }

    public AbstractHabit(String name, String description) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
    }

    public AbstractHabit(String name, Long ownerId) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.ownerId = ownerId;
    }

    public AbstractHabit(String name, String description, Long ownerId) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
        this.ownerId = ownerId;
    }

    public AbstractHabit(String name, String description, Long ownerId, Map<String, String> levels) {
        this.habitCreation = LocalDateTime.now().toString();
        this.habitName = name;
        this.description = description;
        this.ownerId = ownerId;
        this.levels = levels;

    }
    public AbstractHabit(LocalDateTime habitCreation, String name, Long ownerId) {
            this.habitCreation = habitCreation.toString();
            this.habitName = name;
            this.ownerId = ownerId;
        }

    public AbstractHabit(LocalDateTime habitCreation, String name, String description, Long ownerId) {
            this.habitCreation = habitCreation.toString();
            this.habitName = name;
            this.description = description;
            this.ownerId = ownerId;
        }


        public Map<String, String> getLevels () {
            return levels;
        }

        public String toString () {
            return this.habitName + " - " + this.description + " - from user " + this.ownerId + " - " + this.levels;
        }
    }
