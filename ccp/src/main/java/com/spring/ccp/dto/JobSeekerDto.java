package com.spring.ccp.dto;

import jakarta.validation.constraints.NotBlank;

public record JobSeekerDto (
        @NotBlank(message = "Summary is mandatory")
        String summary,

        @NotBlank(message = "Experience is mandatory")
        String experience,
        @NotBlank(message = "Skills is mandatory")
        String skills,

        int userId
)
{

}

