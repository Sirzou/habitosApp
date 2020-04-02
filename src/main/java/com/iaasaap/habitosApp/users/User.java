package com.iaasaap.habitosApp.users;

import com.iaasaap.habitosApp.habits.AbstractHabit;
import com.iaasaap.habitosApp.habits.SketchHabit;
import lombok.Getter;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @Relationship(type = "SKETCHED HABIT", direction = Relationship.OUTGOING)
    private List<SketchHabit> sketchedHabits;

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
                ", habits sketched=" + (sketchedHabits == null ? "" : sketchedHabits) +
                '}';
    }

    public void setSketchFromAbstractHabit(AbstractHabit abstractHabit) {
        List<AbstractHabit> listaAbstractHabits = new ArrayList<AbstractHabit>();
        listaAbstractHabits.add(abstractHabit);
        setSketchFromAbstractHabits(listaAbstractHabits);
    }

    public List<SketchHabit> getSketchedHabits() {
        if (this.sketchedHabits == null) {
            this.sketchedHabits = new ArrayList<>();
        }
        return this.sketchedHabits;
    }

    public void setSketchFromAbstractHabits(List<AbstractHabit> abstractHabits) {
        abstractHabits.stream()
                .forEach(abstractHabit -> sketchedHabits.add(new SketchHabit(abstractHabit)));
    }

}
