package com.spring.ccp.controller;


import com.spring.ccp.exceptions.ResourceNotFoundException;
import com.spring.ccp.model.Users;
import com.spring.ccp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    // GET ALL USERS
    @GetMapping("/api/user/all")
    public List<Users> getAll() {
        return userService.getAll();
    }

    // ADD USER
    @PostMapping("/api/user/add")
    public void addUser(@RequestBody Users user) {
        userService.addUser(user);
    }

    // GET USER BY ID
    @GetMapping("/api/user/get-one/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id) {

        try {
            Users user = userService.getById(id);

            return ResponseEntity
                    .ok(user);

        } catch (ResourceNotFoundException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // DELETE USER
    @DeleteMapping("/api/user/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {

        try {
            userService.deleteUser(id);

            return ResponseEntity
                    .ok()
                    .build();

        } catch (ResourceNotFoundException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // UPDATE USER
    @PutMapping("/api/user/update/{id}")
    public ResponseEntity<Object> update(
            @PathVariable int id,
            @RequestBody Users updatedUser) {

        try {

            userService.updateUser(id, updatedUser);

            return ResponseEntity
                    .ok()
                    .build();

        } catch (ResourceNotFoundException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
