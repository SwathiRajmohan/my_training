package com.spring.ccp.repository;

import com.spring.ccp.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    Employer findByEmail(String email);

    List<Employer> findByCompanyName(String companyName);
}
