package com.SpringFirstAttempt.sfa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    public SchoolRepository schoolRepository;

    public SchoolMapper schoolMapper;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }


    public SchoolDto create(SchoolDto schoolDto){
        School school=schoolMapper.dtoToSchool(schoolDto);
        return schoolMapper.toSchoolDto(schoolRepository.save(school));
    }

    public List<SchoolDto> getAllSchools(){
        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolDto).collect(Collectors.toList());
    }


}
