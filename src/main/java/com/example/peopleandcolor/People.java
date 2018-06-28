package com.example.peopleandcolor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "person")
    private Set<Colors> colors;

    public People() {
        colors =new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Colors> getColors() {
        return colors;
    }

    public void setColors(Set<Colors> colors) {
        this.colors = colors;
    }
}
