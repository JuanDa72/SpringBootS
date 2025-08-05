package com.SpringFirstAttempt.sfa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolController(SchoolRepository schoolRepository){
        this.schoolRepository=schoolRepository;
    }

    //Para insertar un dato
    @PostMapping("/schools")
    public School create(@RequestBody School school){
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }








}
