package com.dao;

import com.model.Users;

public interface AuthDao {

    Users login(String email, String password);
}