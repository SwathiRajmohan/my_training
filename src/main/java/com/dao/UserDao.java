package com.dao;

import com.model.Users;

import java.util.List;

public interface UserDao {

    void save(Users user);

    List<Users> findAll();

    Users getById(int id);

    void update(Users user);

    void delete(int id);
}