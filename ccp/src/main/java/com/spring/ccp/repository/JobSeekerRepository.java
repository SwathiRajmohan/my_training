package com.spring.ccp.repository;


import com.spring.ccp.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

    List<JobSeeker> findByExperience(String experience);

    JobSeeker findByUserEmail(String email);

    List<JobSeeker> findBySkills(String skills);
}
