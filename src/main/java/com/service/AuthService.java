package com.service;

import com.model.Users;
import org.hibernate.Session;

public class AuthService {

    private Session session;

    public AuthService(Session session) {
        this.session = session;
    }

    public Users login(String email, String password) {

        String hql =
                "from Users where email = :email and password = :password";

        return session
                .createQuery(hql, Users.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
    }
}