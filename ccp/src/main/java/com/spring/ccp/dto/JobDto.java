package com.spring.ccp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JobDto(
        @NotBlank(message = "Title is mandatory")
        String title,
        @NotBlank(message = "Description is mandatory")
        String description,
        @Min(value = 1,message = "Salary must be greater than 0")
        double salary,
        @NotBlank(message = "Location is mandatory")
        String location,
        @NotNull(message = "Employer ID is mandatory")
        int employerId
) {
}
