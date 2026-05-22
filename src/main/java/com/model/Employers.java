package com.model;

import jakarta.persistence.*;

@Entity
public class Employers extends BaseClass{

    private String companyName;

    private String companyAddress;

    private String website;

    @OneToOne
    private Users users;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
