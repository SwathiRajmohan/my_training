package com.model;

import jakarta.persistence.*;

@Entity
public class Employers extends BaseClass{

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String companyAddress;

    private String website;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


}
