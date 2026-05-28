package com.spring.ccp.mapper;

import com.spring.ccp.dto.UserDto;
import com.spring.ccp.dto.UserRespDto;
import com.spring.ccp.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public Users mapDtoToEntity(UserDto dto){

        Users user = new Users();

        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setRole(dto.role());

        return user;
    }

    public UserRespDto mapEntityToDto(Page<Users> pages){

        long totalElements = pages.getTotalElements();
        int totalPages = pages.getTotalPages();
        List<Users> list = pages.getContent();

        return new UserRespDto(
                totalElements,
                totalPages,
                list
        );
    }
}