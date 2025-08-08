package com.SpringFirstAttempt.sfa.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {


    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper=new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDto studentDto=new StudentDto("jhon","Doe","jhon@email.com",1);
        Student student=studentMapper.toStudent(studentDto);

        Assertions.assertEquals(studentDto.firstName(), student.getFirstName());
        Assertions.assertEquals(studentDto.lastName(), student.getLastName());
        Assertions.assertEquals(studentDto.email(), student.getEmail());
        Assertions.assertNotNull(student.getSchool());
        Assertions.assertEquals(studentDto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToStudentDto(){
        Student student=new Student(1,"jhon","smith","jhon@email",20);
        StudentResponseDto studentDto=studentMapper.studentToResponseDto(student);

        assertEquals(student.getFirstName(),studentDto.firstName());
        assertEquals(student.getLastName(),studentDto.lastName());
        assertEquals(student.getEmail(),studentDto.email());


    }


    //Considerando el caso excepcional en el que dto sea nulo
    @Test
    public void should_throw_null_pointer_excepction_when_studentDto_is_null(){
        var message=assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
        assertEquals("The student DTO is null",message.getMessage());
    }



}