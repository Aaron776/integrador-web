package com.rafael.falconi.example.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Employee {

    @Id
    @Column(length = 10)
    @Size(min=10,max = 10)
    private String Ci;

    private String name,lastName,password;

    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private Area area;

    public Employee() {
    }

    public Employee(@Size(min = 10, max = 10) String ci, String name, String lastName, String password, Position position, Area area) {
        Ci = ci;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.position = position;
        this.area = area;
    }

    public String getCi() {
        return Ci;
    }

    public void setCi(String ci) {
        Ci = ci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
