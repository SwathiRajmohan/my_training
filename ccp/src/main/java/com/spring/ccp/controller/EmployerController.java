package com.spring.ccp.controller;

import com.spring.ccp.dto.EmployerDto;
import com.spring.ccp.dto.EmployerRespDto;
import com.spring.ccp.model.Employer;
import com.spring.ccp.service.EmployerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
@AllArgsConstructor
public class EmployerController {
    private EmployerService employerService;

    //add emp
    @GetMapping("/add")
    public void addEmployer(@Valid @RequestBody EmployerDto dto){
        employerService.addEmployer(dto);
    }

    //get all
    @GetMapping("/all")
    public List<Employer> getAllEmployers(){
        return employerService.getAllEmployers();
    }

    //get employer by id
    @GetMapping("/get-one/{id}")
    public Employer getEmployerById(@PathVariable int id){
        return employerService.getByEmployerId(id);
    }
    //get employer by email
    @GetMapping("/by-email")
    public EmployerRespDto getByEmployerEmail(@RequestParam String email){
        return employerService.getByEmployerEmail(email);
    }

    //get employer by company name
    @GetMapping("/by-company")
    public List<Employer> getByCompanyName(@RequestParam String companyName){
        return employerService.getByCompanyName(companyName);
    }
    //delete employer
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        employerService.deleteById(id);
    }
}
