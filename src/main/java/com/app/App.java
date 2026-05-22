package com.app;

import com.config.AppConfig;
import com.dao.AuthDao;
import com.dao.UserDao;
import com.enums.Role;
import com.exception.ResourceNotFoundException;
import com.model.Users;
import jakarta.persistence.NoResultException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AuthDao authDao = context.getBean(AuthDao.class);
        UserDao userDao = context.getBean(UserDao.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("---------CAREERCRAFTER LOGIN-----------");
        System.out.println("Enter your email:");
        String email = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        try{
            Users loginUser=authDao.login(email,password);
            switch (loginUser.getRole().toString()){
                case "JOBSEEKER":
                    System.out.println("JOBSEEKER MENU");
                    while(true){
                        System.out.println("1. Add User");
                        System.out.println("2. Get All User");
                        System.out.println("3. Get User By Id");
                        System.out.println("4. Update User");
                        System.out.println("5. Delete User");
                        System.out.println("0. Exit");
                        int op=sc.nextInt();
                        if(op==0)
                            break;
                        switch (op){
                            case 1:
                                Users user=new Users();
                                System.out.println("Enter email:");
                                user.setEmail(sc.next());
                                System.out.println("Enter password:");
                                user.setPassword(sc.next());
                                System.out.println("Enter role:");
                                user.setRole(Role.valueOf(sc.next()));
                                userDao.save(user);
                                System.out.println("User added successfully");
                                break;
                            case 2:
                                userDao.findAll().forEach(System.out::println);
                                break;
                            case 3:
                                System.out.println("Enter ID");
                                int id = sc.nextInt();
                                try {
                                    System.out.println(userDao.getById(id));
                                }
                                catch(ResourceNotFoundException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                System.out.println("Enter User ID");
                                id = sc.nextInt();
                                try {
                                    Users existingUser = userDao.getById(id);
                                    System.out.println("Enter New Email");
                                    existingUser.setEmail(sc.next());
                                    userDao.update(existingUser);
                                    System.out.println("User Updated");
                                }
                                catch(ResourceNotFoundException e){
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 5:
                                System.out.println("Enter User ID");
                                id = sc.nextInt();
                                try {
                                    userDao.delete(id);
                                    System.out.println("User Deleted");
                                }
                                catch(ResourceNotFoundException e){

                                    System.out.println(e.getMessage());
                                }
                                break;
                        }
                    }
                    break;
            }
        }
        catch(NoResultException e){
            System.out.println("Invalid Credentials");
        }
        context.close();
    }
}
