package com.spring.ccp.service;

import com.spring.ccp.dto.UserDto;
import com.spring.ccp.dto.UserRespDto;
import com.spring.ccp.exceptions.ResourceNotFoundException;
import com.spring.ccp.mapper.UserMapper;
import com.spring.ccp.model.Users;
import com.spring.ccp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void addUser(UserDto dto) {
        Users user=userMapper.mapDtoToEntity(dto);
        userRepository.save(user);
    }

    public List<Users> getAll() {
        return userRepository.findAll();
    }
    public UserRespDto getAllWithPagination(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<Users> pages=userRepository.findAll(pageable);
        return userMapper.mapEntityToDto(pages);
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
