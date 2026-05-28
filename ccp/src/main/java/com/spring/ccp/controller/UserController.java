package com.spring.ccp.controller;


import com.spring.ccp.dto.UserDto;
import com.spring.ccp.dto.UserRespDto;
import com.spring.ccp.exceptions.ResourceNotFoundException;
import com.spring.ccp.model.Users;
import com.spring.ccp.service.UserService;
import jakarta.validation.Valid;
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

    @GetMapping("/api/user/all/v2")
    public UserRespDto getAllV2(
            @RequestParam int page,
            @RequestParam int size
    ){
        return userService.getAllWithPagination(page, size);
    }

    // ADD USER
    @PostMapping("/api/user/add")
    public void addUser(@Valid @RequestBody UserDto dto)
    {
        userService.addUser(dto);
    }

    // GET USER BY ID
    @GetMapping("/api/user/get-one/{id}")
    public ResponseEntity<Users> getById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    // DELETE USER
    @DeleteMapping("/api/user/delete/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    // UPDATE USER
    @PutMapping("/api/user/update/{id}")
    public void update(
            @PathVariable int id,
            @RequestBody Users updatedUser) {
        userService.updateUser(id, updatedUser);
    }
}
