package com.iaasaap.habitosApp.users;

import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.ExecHabit;
import com.iaasaap.habitosApp.habits.SketchHabit;
import lombok.Getter;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NodeEntity
@Getter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Property(name = "name")
    private String name;
    @Property(name = "signupTS")
    private String signupTS;
    @Property(name = "birthDate")
    private String birthDate;

    public User(String name, String birthDate) {
        signupTS = LocalDateTime.now().toString();
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "personUUID=" + id +
                ", name='" + name + '\'' +
                ", signupTS=" + signupTS +
                ", birthDate=" + birthDate +
                //", habits sketched=" + (sketchedHabits == null ? "" : sketchedHabits) +
                '}';
    }

    /*public List<SketchHabit> getSketchedHabits() {

        if (this.sketchedHabits == null) {
            this.sketchedHabits = new ArrayList<>();
        }
        return this.sketchedHabits;
    }*/

    /*public void setSketchFromAbstractHabit(AbstractHabit abstractHabit) {
        setSketchFromAbstractHabits(Arrays.asList(abstractHabit));
    }

    public void setSketchFromAbstractHabits(List<AbstractHabit> abstractHabits) {
        if (this.sketchedHabits == null) {
            this.sketchedHabits = new ArrayList<>();
        }
        abstractHabits.stream()
                .forEach(abstractHabit -> sketchedHabits.add(new SketchHabit(abstractHabit)));
    }*/

    /*public void setExecFromSketchHabit(SketchHabit sketchedHabits) {
        setExecFromSketchHabits(Arrays.asList(sketchedHabits));
    }

    public void setExecFromSketchHabits(List<SketchHabit> sketchedHabits) {
        if (this.execHabits == null) {
            this.execHabits = new ArrayList<>();
        }
        List<ExecHabit> newExecHabits = sketchedHabits.stream()
                .map(sketchedHabit -> new ExecHabit(sketchedHabit))
                .collect(Collectors.toList());

        execHabits.addAll(newExecHabits);
    }*/
}
