package com.iaasaap.habitosApp.RESTservices;

public final class Constants {
    public static final String CURRENTVERSION = "/api/v1";

    public static final String GET_USERS = "/users";
    public static final String GET_USER = "/users/{userId}";
    public static final String LINK_USER_WITH_HABIT =  "/linkUserHabit/{userId}/{habitId}";

    public static final String GET_ABSTRACT_HABITS = "/habit/abstracts";
    public static final String GET_ABSTRACT_HABIT = "/habit/abstracts/{habitId}";
    public static final String SET_ABSTRACT_LEVELS = "/habit/set-abstract-levels/{habitId}";

    public static final String CREATE_SKETCH_HABIT_FROM_ABSTRACT = "/habit/sketches/{abstractHabitId}";
    public static final String GET_SKETCH_HABITS = "/habit/sketches";
    public static final String GET_SKETCH_HABIT = "/habit/sketches/{habitId}";
    public static final String SET_SKETCH_LEVELS = "/habit/set-sketch-levels/{habitId}";

    public static final String CREATE_EXEC_HABIT_FROM_SKETCH = "/habit/execs/{sketchHabitId}";
    public static final String GET_EXEC_HABIT = "/habit/execs/{habitId}";
    public static final String EDIT_EXEC_HABIT = "/habit/exec/edit/{habitId}";

    public static final String OWN_ABSTRACTHABIT = "/user/{userId}/abstract-habit/{abstractHabit}";

    public static final String GET_SCHEDULES = "/habit/schedules";
    public static final String GET_SCHEDULE = "/habit/schedules/{scheduleId}";
}
