package com.SpringFirstAttempt.sfa.school;

import com.SpringFirstAttempt.sfa.school.School;
import com.SpringFirstAttempt.sfa.school.SchoolDto;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    //Método para pasar de dtoSchool a School, usamos el constructuro que solo recibe el nombre
    public School dtoToSchool(SchoolDto schoolDto){
        return new School(schoolDto.name());
    }

    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }


}
