package com.model;


import jakarta.persistence.*;

@Entity
public class Jobseekers extends BaseClass{

    private String name;

    private String phoneNo;

    private int experience;

    @OneToOne
    private Users users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
