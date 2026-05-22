package com.model;

import jakarta.persistence.*;

@Entity
public class Jobs extends BaseClass{

    private String title;

    private String description;

    private double salary;

    @ManyToOne
    private Employers employers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
