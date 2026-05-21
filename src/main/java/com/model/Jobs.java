package com.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Jobs  extends BaseClass{

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private double salary;

    private String location;

    @ManyToOne
    @JoinColumn(name = "employers_id")
    private Employers employers;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employers getEmployers() {
        return employers;
    }

    public void setEmployers(Employers employers) {
        this.employers = employers;
    }

}
