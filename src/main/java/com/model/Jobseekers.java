package com.model;

import jakarta.persistence.*;

@Entity
public class Jobseekers extends BaseClass{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNo;

    private String summary;

    private int experience;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users user;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

//    @Override
//    public String toString() {
//        return "Jobseekers{" +
//                " user=" + user +
//                ", name='" + name + '\'' +
//                ", phoneNo='" + phoneNo + '\'' +
//                ", summary='" + summary + '\'' +
//                ", experience=" + experience +
//                '}';
//    }
}
