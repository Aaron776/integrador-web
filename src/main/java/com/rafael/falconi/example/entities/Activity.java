package com.rafael.falconi.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;

    private String title;

    private Date date;

    @Lob
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private Employee employee;

    public Activity() {
    }

    public Activity(int id, String title, Date date, String description, Employee employee) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
