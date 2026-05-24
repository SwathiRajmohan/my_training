package com.spring.ccp.service;

import com.spring.ccp.exceptions.ResourceNotFoundException;
import com.spring.ccp.model.Users;
import com.spring.ccp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addUser(Users users) {
        userRepository.save(users);
    }

    public List<Users> getAll() {
        return userRepository.findAll();
    }
    public Users getById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid User ID"));
    }

    public void deleteUser(int id) {
        getById(id);
        userRepository.deleteById(id);
    }

    public void updateUser(int id, Users updatedUser) {

        Users existingUser = getById(id);

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRole(updatedUser.getRole());

        userRepository.save(existingUser);
    }

}
