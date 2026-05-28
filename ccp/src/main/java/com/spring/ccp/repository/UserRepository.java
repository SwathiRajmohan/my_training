package com.spring.ccp.repository;

import com.spring.ccp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(String email);
}
