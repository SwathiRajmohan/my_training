package com.spring.ccp.mapper;

import com.spring.ccp.dto.EmployerJobDto;
import com.spring.ccp.dto.JobRespDto;
import com.spring.ccp.model.Jobs;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {

    public JobRespDto mapToDto(Jobs jobs){
        return new JobRespDto(
                jobs.getId(),
                jobs.getTitle(),
                jobs.getDescription(),
                jobs.getSalary(),
                jobs.getLocation(),
                jobs.getPostedDate(),

                jobs.getEmployer().getId(),
                jobs.getEmployer().getCompanyName()
        );
    }

    public EmployerJobDto mapEmployerJobDto(Jobs jobs){
        return new EmployerJobDto(
                jobs.getEmployer().getId(),
                jobs.getEmployer().getCompanyName(),

                jobs.getId(),
                jobs.getTitle(),
                jobs.getSalary(),
                jobs.getLocation()
        )
    }
}
