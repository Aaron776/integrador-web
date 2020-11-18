package com.rafael.falconi.example.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private Area area;

    public Area() {
    }

    public Area(int id, String name, Area area) {
        this.id = id;
        this.name = name;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Area that = (Area) obj;
        return id == that.getId();
    }
}
