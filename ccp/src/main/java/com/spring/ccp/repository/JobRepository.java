package com.spring.ccp.repository;


import com.spring.ccp.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Jobs, Integer> {

    List<Jobs> findByEmployerId(int employerId);

    //by location

    List<Jobs> findByLocation(String location);

    //by title
    List<Jobs> findByTitle(String title);

    //by companyname in which the emp belongs to
    List<Jobs> findByEmployerCompanyName(String companyName);

    //by salary
    List<Jobs> findBySalary(double salary);
}
