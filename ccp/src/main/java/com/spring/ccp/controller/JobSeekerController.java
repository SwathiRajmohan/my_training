package com.spring.ccp.controller;

import com.spring.ccp.dto.JobSeekerDto;
import com.spring.ccp.dto.JobSeekerRespDto;
import com.spring.ccp.model.JobSeeker;
import com.spring.ccp.service.JobSeekerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseeker")
@AllArgsConstructor
public class JobSeekerController {
    private final JobSeekerService jobSeekerService;
    
    //add
    @PostMapping("/add/{userId}")
    public void addJobSeeker(@Valid @RequestBody JobSeekerDto dto,@PathVariable int userId){
        jobSeekerService.addJobSeeker(dto,userId);
    }
    
    //get all
    @GetMapping("/all")
    public List<JobSeeker> getAllJobSeeker(){
        return jobSeekerService.getAllJobSeekers();
    }
    
    //get by id
    @GetMapping("/get-one/{id}")
    public ResponseEntity<JobSeekerRespDto> getById(@PathVariable int id){
        return ResponseEntity.ok(jobSeekerService.getById(id));
    }
    
    //delete
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        jobSeekerService.deleteById(id);
    }
    
    //update
    @PutMapping("/update/{id}")
    public void updateJobSeeker(@PathVariable int id,@RequestBody JobSeeker updatedJobSeeker){
        jobSeekerService.updateJobSeeker(id,updatedJobSeeker);
    }
    
    //get by experience
    @GetMapping("/experience")
    public List<JobSeekerRespDto> getByExperience(@RequestParam String experience){
        return jobSeekerService.getByExperience(experience);
    }
    
    //get by email
    @GetMapping("/email")
    public ResponseEntity<JobSeekerRespDto> getByEmail(@RequestParam String email){
        return ResponseEntity.ok(jobSeekerService.getByEmail(email));
    }
    
}
