package com.SpringFirstAttempt.sfa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student postStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    //En este caso retorna un objeto de tipo optinal, si no encuentra
    //un estudiante con ese id entonces crea uno objeto estudiante vacìo y lo retorna
    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer id){
        return studentRepository.findById(id).orElse(new Student());
    }


    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name") String firstName){
        return studentRepository.findAllByFirstNameContaining(firstName);
    }


    //Priner metodo en el que intentamos eliminar
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id){
        studentRepository.deleteById(id);
    }



}
