package com.iaasaap.habitosApp.habits.schedules;

import lombok.Data;
import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.time.LocalDateTime;

@NodeEntity
@Getter
@Data
public class SortDay {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String DoW;
    @Property
    private String levelAchieved;
    @Property
    private LocalDateTime scheduledTS;
    @Property
    private LocalDateTime achievedTS;
    @Property
    private boolean wasAchieved;
    @Property
    private boolean isToDo;


}
