package com.dao_impl;

import com.dao.AuthDao;
import com.model.Users;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class AuthDaoImpl implements AuthDao {
    @PersistenceContext
    private EntityManager em;

    public Users login(String email, String password){
        Query query = em.createQuery("select u from Users u where u.email =:email and u.password =:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (Users) query.getSingleResult();
    }

}
