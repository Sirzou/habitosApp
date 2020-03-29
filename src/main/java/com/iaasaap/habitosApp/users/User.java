package com.iaasaap.habitosApp.users;

import lombok.Getter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.time.LocalDateTime;

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
        //userUUID = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
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
                '}';
    }
}