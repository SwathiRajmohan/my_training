package com.spring.ccp.service;

import com.spring.ccp.dto.JobDto;
import com.spring.ccp.dto.JobRespDto;
import com.spring.ccp.exceptions.ResourceNotFoundException;
import com.spring.ccp.mapper.JobMapper;
import com.spring.ccp.model.Employer;
import com.spring.ccp.model.Jobs;
import com.spring.ccp.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final EmployerService employerService;
    private final JobMapper jobMapper;

    // ADD JOB
    public void addJob(JobDto dto, int employerId){

        // fetch employer from DB
        Employer employer =
                employerService.getByEmployerId(employerId);

        // create Job entity
        Jobs job = new Jobs();

        job.setTitle(dto.title());
        job.setDescription(dto.description());
        job.setSalary(dto.salary());
        job.setLocation(dto.location());
        job.setPostedDate(LocalDate.now());

        // attach employer
        job.setEmployer(employer);

        // save
        jobRepository.save(job);
    }

    // GET ALL JOBS
    public List<Jobs> getAllJobs(){

        return jobRepository.findAll();
    }

    // GET JOB ENTITY BY ID
    public Jobs getJobEntityById(int id){

        return jobRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Invalid Job ID"
                        ));
    }

    // GET JOB DTO BY ID
    public JobRespDto getById(int id){

        Jobs job = getJobEntityById(id);

        return jobMapper.mapToDto(job);
    }

    // DELETE JOB
    public void deleteById(int id){

        // validation
        getJobEntityById(id);

        jobRepository.deleteById(id);
    }

    // UPDATE JOB
    public void updateJob(int id, Jobs updatesJob){

        Jobs existingJob = getJobEntityById(id);

        existingJob.setTitle(updatesJob.getTitle());
        existingJob.setDescription(updatesJob.getDescription());
        existingJob.setSalary(updatesJob.getSalary());
        existingJob.setLocation(updatesJob.getLocation());

        jobRepository.save(existingJob);
    }

    // GET JOBS BY EMPLOYER
    public List<JobRespDto> getByEmployer(int employerId){
        List<Jobs> jobs =
                jobRepository.findByEmployerId(employerId);
        return jobs.stream()
                .map(jobMapper::mapToDto)
                .toList();
    }

    // GET JOBS BY LOCATION
    public List<JobRespDto> getByLocation(String location){
        List<Jobs> jobs =
                jobRepository.findByLocation(location);
        return jobs.stream()
                .map(jobMapper::mapToDto)
                .toList();
    }

    // GET JOBS BY TITLE
    public List<JobRespDto> getByTitle(String title){
        List<Jobs> jobs =
                jobRepository.findByTitle(title);
        return jobs.stream()
                .map(jobMapper::mapToDto)
                .toList();
    }

    // GET JOBS BY COMPANY NAME
    public List<JobRespDto> getByCompanyName(String companyName){
        List<Jobs> jobs =
                jobRepository.findByEmployerCompanyName(companyName);
        return jobs.stream()
                .map(jobMapper::mapToDto)
                .toList();
    }
    // GET JOBS BY SALARY
    public List<JobRespDto> getBySalary(double salary){
        List<Jobs> jobs =
                jobRepository.findBySalary(salary);
        return jobs.stream()
                .map(jobMapper::mapToDto)
                .toList();
    }
}