package com.spring.ccp.service;

import com.spring.ccp.dto.JobSeekerDto;
import com.spring.ccp.dto.JobSeekerRespDto;
import com.spring.ccp.exceptions.ResourceNotFoundException;
import com.spring.ccp.mapper.JobMapper;
import com.spring.ccp.mapper.JobSeekerMapper;
import com.spring.ccp.model.JobSeeker;
import com.spring.ccp.model.Users;
import com.spring.ccp.repository.JobSeekerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;
    private final UserService userService;
    private final JobMapper jobMapper;
    private final JobSeekerMapper jobSeekerMapper;

    //add jobseeker
    public void addJobSeeker(JobSeekerDto dto, int userId) {

        //fetch user by id
        Users user=userService.getById(dto.userId());
        //dto -> entity
        JobSeeker jobSeeker= new JobSeeker();
        jobSeeker.setSummary(dto.summary());
        jobSeeker.setExperience(dto.experience());
        jobSeeker.setSkills(dto.skills());
        jobSeeker.setUser(user);
        jobSeekerRepository.save(jobSeeker);
    }

    //get all
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    //get jobseeker entity by id
    public JobSeeker getJobSeekerEntityById(int id){
        return jobSeekerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid JobSeeker Id"));
    }

    //get dto by id
    public JobSeekerRespDto getById(int id){
        JobSeeker jobSeeker=getJobSeekerEntityById(id);
        return jobSeekerMapper.mapToDto(jobSeeker);
    }

    // update
    public void updateJobSeeker(int id,JobSeeker updatedJobSeeker) {
        JobSeeker existingJobSeeker=getJobSeekerEntityById(id);
        existingJobSeeker.setSummary(updatedJobSeeker.getSummary());
        existingJobSeeker.setExperience(updatedJobSeeker.getExperience());
        existingJobSeeker.setSkills(updatedJobSeeker.getSkills());
        jobSeekerRepository.save(existingJobSeeker);
    }

    //delete jobseeker
    public void deleteById(int id){
        getJobSeekerEntityById(id);
        jobSeekerRepository.deleteById(id);
    }

    //get by email
    public JobSeekerRespDto getByEmail(String email){
        JobSeeker jobSeeker=jobSeekerRepository.findByUserEmail(email);
        return jobSeekerMapper.mapToDto(jobSeeker);
    }

    //get by skill
    public List<JobSeeker> getBySkills(String skills){
        return jobSeekerRepository.findBySkills(skills);
    }

    //get by experience
    public List<JobSeekerRespDto> getByExperience(String experience){
        return jobSeekerRepository.findByExperience(experience);
    }
}
