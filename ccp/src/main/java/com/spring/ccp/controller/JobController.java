package com.spring.ccp.controller;

import com.spring.ccp.dto.JobDto;
import com.spring.ccp.dto.JobRespDto;
import com.spring.ccp.model.Jobs;
import com.spring.ccp.service.JobService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
@AllArgsConstructor
public class JobController {
    private final JobService jobService;

    //add job
    @PostMapping("/add/{employerId)")
    public void addJob(@Valid @RequestBody JobDto dto,
                       @PathVariable int employerId){
        jobService.addJob(dto,employerId);
    }
    //get all jobs
    @GetMapping("/all")
    public List<Jobs> getAllJobs(){
        return jobService.getAllJobs();
    }
    //get job by id
    @GetMapping("/get-one/{id}")
    public ResponseEntity<JobRespDto> getById(@PathVariable int id){
        return ResponseEntity
                .ok(jobService.getById(id));
    }

    //update job
    @PutMapping("/update/{id}")
    public void updateJob(@PathVariable int id,@RequestBody Jobs updatesJob){
        jobService.updateJob(id,updatesJob);
    }
    //delete job
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        jobService.deleteById(id);
    }

    //get by location
    @GetMapping("/location")
    public List<JobRespDto> getByLocation(@RequestParam String location){
        return jobService.getByLocation(location);
    }
    //get by employer
    @GetMapping("/employer/{employerId}")
    public List<JobRespDto> getByEmployer(@PathVariable int employerId){
        return jobService.getByEmployer(employerId);
    }
    //get by salary
    @GetMapping("/salary")
    public List<JobRespDto> getBySalary(@RequestParam double salary){
        return jobService.getBySalary(salary);
    }
}
