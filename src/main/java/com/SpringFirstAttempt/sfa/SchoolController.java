package com.SpringFirstAttempt.sfa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolService schoolService;


    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    //Para insertar un dato
    /*Volvemos a usar un dto para insertar y para retornar */
    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto schoolDto){
        return schoolService.create(schoolDto);
    }


    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools(){
        return schoolService.getAllSchools();
    }


}
