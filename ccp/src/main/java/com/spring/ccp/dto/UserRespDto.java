package com.spring.ccp.dto;

import com.spring.ccp.model.Users;

import java.util.List;

public record UserRespDto(
        long totalRecords,
        int totalPages,
        List<Users> data
) {
}