package com.config;

import com.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            //DB Credentials,url
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/careerpro?createDatabaseIfNotExist=true");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "root123");
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");

            // set the dialect
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            configuration.setProperty("hibernate.hbm2ddl.auto", "update");

            // Add model classes that we will create
            configuration.addAnnotatedClass(Users.class);
            configuration.addAnnotatedClass(Employers.class);
            configuration.addAnnotatedClass(Jobs.class);
            configuration.addAnnotatedClass(Jobseekers.class);
            configuration.addAnnotatedClass(Applications.class);

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeFactory() {
        sessionFactory.close();
    }
}
