package com.iaasaap.habitosApp.habits.schedules;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.List;

@NodeEntity
@Getter
@Setter
@Data
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
    private String antelacion;
    @Relationship(type = "SORT")
    private List<SortDay> sortDays;

    public String getScheduleType() {
        return scheduleType;
    }

    public String getDefaultTime() {
        return defaultTime;
    }

    public boolean isPersonalized() {
        return isPersonalized;
    }

    public String getAntelacion() {
        return antelacion;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public void setDefaultTime(String defaultTime) {
        this.defaultTime = defaultTime;
    }

    public void setPersonalized(boolean personalized) {
        isPersonalized = personalized;
    }

    public void setAntelacion(String antelacion) {
        this.antelacion = antelacion;
    }

    public void setSortDays(List<SortDay> sortDays) {
        this.sortDays = sortDays;
    }

    public List<SortDay> getSortDays() {
        return sortDays;
    }
}
