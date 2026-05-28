package com.spring.ccp.dto;

import java.time.LocalDate;

public record JobRespDto(
        int jobId,
        String title,
        String description,
        double salary,
        String location,
        LocalDate postedDate,

        int employerId,
        String companyName
){
}
