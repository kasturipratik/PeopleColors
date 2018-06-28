package com.example.peopleandcolor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Colors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String colorName;

    @ManyToMany()
    private Set<People> person;

    public Colors() {
        person = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Set<People> getPerson() {
        return person;
    }

    public void setPerson(Set<People> person) {
        this.person = person;
    }
}
