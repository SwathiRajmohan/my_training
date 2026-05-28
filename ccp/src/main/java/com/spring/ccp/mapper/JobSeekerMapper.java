package com.spring.ccp.mapper;

import com.spring.ccp.dto.JobSeekerDto;
import com.spring.ccp.dto.JobSeekerRespDto;
import com.spring.ccp.model.JobSeeker;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerMapper {
    public static JobSeeker mapToEntity(JobSeekerDto dto){
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setSummary(dto.summary());
        jobSeeker.setExperience(dto.experience());
        jobSeeker.setSkills(dto.skills());
        return jobSeeker;
    }

    public JobSeekerRespDto mapToDto(JobSeeker jobSeeker){
        return new JobSeekerRespDto(
                jobSeeker.getId(),
                jobSeeker.getSummary(),
                jobSeeker.getExperience(),
                jobSeeker.getSkills(),

                jobSeeker.getUser().getId(),
                jobSeeker.getUser().getEmail()
        );
    }
}
