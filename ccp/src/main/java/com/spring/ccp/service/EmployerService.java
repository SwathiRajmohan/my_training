package com.spring.ccp.service;

import com.spring.ccp.dto.EmployerDto;
import com.spring.ccp.dto.EmployerRespDto;
import com.spring.ccp.exceptions.ResourceNotFoundException;
import com.spring.ccp.mapper.EmployerMapper;
import com.spring.ccp.model.Employer;
import com.spring.ccp.model.Users;
import com.spring.ccp.repository.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final UserService userService;
    private final EmployerMapper employerMapper;

    //Add Employer
    public void addEmployer(EmployerDto dto) {
        Users user=userService.getById(dto.userId());
        Employer employer = new Employer();
        employer.setCompanyName(dto.companyName());
        employer.setCompanyAddress(dto.companyAddress());
        employer.setWebsite(dto.website());
        employer.setUser(user);
        employerRepository.save(employer);
    }

    //get all
    public List<Employer> getAllEmployers(){
        return employerRepository.findAll();
    }

    //get emp by id
    public Employer getByEmployerId(int id){

        return employerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Employer ID"));
    }
    //get by email
    public EmployerRespDto getByEmployerEmail(String email
    ){
        Employer employer = employerRepository.findByEmail(email);
        return employerMapper.mapEntityToDto(employer);
    }
    //get employer by companyname
    public List<Employer> getByCompanyName(String companyName){
        return employerRepository
                .findByCompanyName(companyName);
    }
    //delete by id
    public void deleteById(int id){
        employerRepository.deleteById(id);
    }
}
