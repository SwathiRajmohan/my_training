package com.spring.ccp.mapper;

import com.spring.ccp.dto.EmployerRespDto;
import com.spring.ccp.model.Employer;
import org.springframework.stereotype.Component;

@Component
public class EmployerMapper {
    public EmployerRespDto mapEntityToDto(Employer employer) {
        return new EmployerRespDto(
                employer.getId(),
                employer.getCompanyName(),
                employer.getCompanyAddress(),
                employer.getWebsite(),

                employer.getUser().getId(),
                employer.getUser().getEmail()
        );
    }
}
