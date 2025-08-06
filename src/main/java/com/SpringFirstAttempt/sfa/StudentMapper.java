package com.SpringFirstAttempt.sfa;
import org.springframework.stereotype.Service;


@Service
public class StudentMapper {

    StudentRepository studentRepository;


    /*Clase que hace la conversión entre dtoStudent y Student convencional */
    public Student toStudent(StudentDto dto){
        var student= new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        //Creación del objeto school
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }


    //Ahora requerimos de un método que transforme un student a studentResponseDto para retornar esto
    //y así no dar información adicional
    public StudentResponseDto studentToResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }


}
