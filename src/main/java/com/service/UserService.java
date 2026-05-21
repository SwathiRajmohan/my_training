package com.service;

import com.exception.ResourceNotFoundException;
import com.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserService {
    private Session session;

    public UserService(Session session) {
        this.session = session;
    }

    // Insertion

    public void insertUser(Users user) {

        Transaction transaction =
                session.beginTransaction();

        session.persist(user);

        transaction.commit();

        System.out.println("User Inserted");
    }

    // Get all users

    public List<Users> getAllUsers() {
        String hql = "from Users";

        return session
                .createQuery(hql, Users.class)
                .list();
    }

    // Get user by id

    public Users getUserById(int id) {

        String hql =
                "from Users where id = :id";

        Users user = session
                .createQuery(hql, Users.class)
                .setParameter("id", id)
                .uniqueResult();

        if (user == null) {
            throw new ResourceNotFoundException("User Not Found");
        }

        return user;
    }

    // Update
    public void updateUserEmail(int id, String email) {

        Transaction transaction =
                session.beginTransaction();

        String hql =
                "update Users set email = :email where id = :id";

        session.createQuery(hql)
                .setParameter("email", email)
                .setParameter("id", id)
                .executeUpdate();

        transaction.commit();

        System.out.println("User Updated");
    }

    // Delete

    public void deleteUser(int id) {

        Transaction transaction =
                session.beginTransaction();

        String hql =
                "delete from Users where id = :id";
        session.createQuery(hql)
                .setParameter("id", id)
                .executeUpdate();

        transaction.commit();

        System.out.println("User Deleted");
    }
}
