package com.iaasaap.habitosApp.habits;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.time.Period;
import java.util.List;

public class Schedule {
    @Id
    @GeneratedValue
    private Long Id;
    @Property
    private String scheduleType;
    @Property
    private String defaultTime;
    @Property
    private boolean isPersonalized;
    @Property
    private Period antelacion;
    @Relationship(type = "SORT")
    private List<SortDay> sortDay;

}
