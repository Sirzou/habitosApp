package com.iaasaap.habitosApp.RESTservices;

public final class Constants {
    public static final String CREATE_USER = "/createUser/";
    public static final String GET_USERS = "/users/";
    public static final String GET_USER = "/users/{userId}/";
    public static final String LINK_USER_WITH_HABIT =  "/linkUserHabit/{userId}/{habitId}/";

    public static final String CREATE_ABSTRACT_HABIT = "/habit/abstracts/";
    public static final String GET_ABSTRACT_HABITS = "/habit/abstracts/";
    public static final String GET_ABSTRACT_HABIT = "/habit/abstracts/{habitId}/";
    public static final String SET_ABSTRACT_LEVELS = "/habit/setAbstractLevels/{habitId}";

    public static final String CREATE_SKETCH_HABIT = "/habit/createSketch/";
    public static final String CREATE_SKETCH_HABIT_FROM_ABSTRACT = "/habit/createSketch/{habitId}";
    public static final String GET_SKETCH_HABITS = "/habit/sketchs/";
    public static final String GET_SKETCH_HABIT = "/habit/sketchs/{habitId}/";
    public static final String SET_SKETCH_LEVELS = "/habit/setSketchLevels/{habitId}";

    public static final String CREATE_EXEC_HABIT_FROM_SKETCH = "/habit/createExec/{habitId}";
    public static final String GET_EXEC_HABIT = "/habit/execs/{habitId}/";
    public static final String EDIT_EXEC_HABIT = "/habit/exec/edit/{habitId}/";
}
