package com.SpringFirstAttempt.sfa.student;

import com.SpringFirstAttempt.sfa.student.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Pasando todos la lógica del controller

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;


    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto){
        var student=studentMapper.toStudent(studentDto);
        var savedStudent=studentRepository.save(student);
        return studentMapper.studentToResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudents(){
        return studentRepository.findAll().stream().map(studentMapper::studentToResponseDto).collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(Integer id){
        Student student = studentRepository.findById(id).orElse(new Student());
        return studentMapper.studentToResponseDto(student);
    }

    public List<StudentResponseDto> findStudentByName(String firstName){
        return studentRepository.findAllByFirstNameContaining(firstName).stream().map(studentMapper::studentToResponseDto).collect(Collectors.toList());
    }

    public void delete(Integer id){
        studentRepository.deleteById(id);
    }


}
