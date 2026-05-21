package com.controller;

import com.config.HibernateConfig;
import com.exception.ResourceNotFoundException;
import com.model.Users;
import com.service.AuthService;
import com.service.UserService;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {

        HibernateConfig.getSessionFactory();

        System.out.println("CareerCrafter Started");

        Session session =
                HibernateConfig
                        .getSessionFactory()
                        .openSession();

        Scanner sc = new Scanner(System.in);

        UserService userService =
                new UserService(session);

        AuthService authService =
                new AuthService(session);

        System.out.println("------ CareerCrafter LOGIN ------");

        System.out.println("Enter Email:");
        String email = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        try {

            Users user =
                    authService.login(email, password);

            switch (user.getRole().toString()) {

                case "JOBSEEKER":

                    System.out.println("JOBSEEKER MENU");

                    while (true) {

                        System.out.println("1. Get All Users");
                        System.out.println("2. Get User By Id");
                        System.out.println("3. Update User Email");
                        System.out.println("4. Delete User");
                        System.out.println("0. Exit");

                        int op = sc.nextInt();

                        if (op == 0)
                            break;

                        switch (op) {

                            case 1:

                                List<Users> users =
                                        userService.getAllUsers();

                                users.forEach(System.out::println);

                                break;

                            case 2:

                                System.out.println("Enter User ID:");

                                int id = sc.nextInt();

                                try {

                                    Users fetchedUser =
                                            userService.getUserById(id);

                                    System.out.println(fetchedUser);
                                } catch (ResourceNotFoundException e) {

                                    System.out.println(e.getMessage());
                                }

                                break;

                            case 3:

                                System.out.println("Enter User ID:");
                                id = sc.nextInt();

                                sc.nextLine();

                                System.out.println("Enter New Email:");
                                String newEmail = sc.nextLine();

                                userService.updateUserEmail(
                                        id,
                                        newEmail
                                );

                                break;

                            case 4:
                                System.out.println("Enter User ID:");
                                id = sc.nextInt();

                                userService.deleteUser(id);

                                break;

                            default:

                                System.out.println("Invalid Option");
                        }
                    }

                    break;

                case "EMPLOYER":

                    System.out.println("EMPLOYER MENU");
                    break;
            }
        } catch (NoResultException e) {

            System.out.println("Invalid Credentials");
        }

        sc.close();
        session.close();

        HibernateConfig.closeFactory();
    }
}