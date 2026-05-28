package com.spring.ccp.dto;

public record EmployerRespDto (

    int employerId,
    String companyName,
    String companyAddress,
    String website,

    int userId,
    String email
    )

{}
