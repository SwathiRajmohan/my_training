package com.spring.ccp.dto;

public record EmployerJobDto(
        int employerId,
        String companyName,

        int jobId,
        String title,
        double salary,
        String location
) {
}
