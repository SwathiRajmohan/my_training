package com.spring.ccp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String companyAddress;

    private String website;

    @OneToOne
    private Users user; //-->Many Emp can exist but each emp has one user id

    @OneToMany(mappedBy = "employer")
    private List<Jobs> jobs; //one emp can post many jobs
}
