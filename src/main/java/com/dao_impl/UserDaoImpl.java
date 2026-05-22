package com.dao_impl;

import com.dao.UserDao;
import com.exception.ResourceNotFoundException;
import com.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Users user) {
        em.persist(user);
    }

    @Override
    public List<Users> findAll() {
        TypedQuery<Users> query = em.createQuery("select u from Users u", Users.class);
        return query.getResultList();
    }

    @Override
    public Users getById(int id) {
        Users user = em.find(Users.class, id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public void update(Users user) {
        em.merge(user);
    }

    @Override
    public void delete(int id) {
        Users user =
                em.find(Users.class, id);
        if (user == null) {
            throw new ResourceNotFoundException("User Not Found");
        }
        em.remove(user);
    }
}