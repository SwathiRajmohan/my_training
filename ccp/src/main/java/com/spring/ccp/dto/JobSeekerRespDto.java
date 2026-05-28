package com.spring.ccp.dto;

public record JobSeekerRespDto(
        int id,
        String summary,
        String experience,
        String skills,

        int userId,
        String email
) {
}
