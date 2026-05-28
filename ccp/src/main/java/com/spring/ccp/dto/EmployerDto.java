package com.spring.ccp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployerDto (
        @NotBlank(message = "Company name is mandatory")
        String companyName,
        @NotBlank(message = "Company Address is mandatory")
        String companyAddress,

        String website,

        @NotNull(message = "User id is mandatory")
        int userId
){

}
