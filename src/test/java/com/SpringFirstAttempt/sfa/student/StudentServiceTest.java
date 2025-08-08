package com.SpringFirstAttempt.sfa.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Locale;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    //dependencias
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_succesfully_save_a_student(){
        //Given
        StudentDto dto=new StudentDto(
                "jhon",
                "doe",
                "jhon@mail",
                1
        );

        Student student=new Student(
                "jhon",
                "doe",
                "jhon@mail",
                20
        );

        Student savedStudent=new Student(
                "jhon",
                "doe",
                "jhon@mail",
                20
        );

        savedStudent.setId(1);

        //Mock the calls
        //Como no estamos utilizando el verdadero mapper ni la base de datos, tenemos que indicar
        //que es lo que esperamos obtener en cada paso
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.studentToResponseDto(savedStudent)).thenReturn(new StudentResponseDto
                ("jhon", "doe", "jhon@mail"));


        //when
        StudentResponseDto studentResponseDto=studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstName(),studentResponseDto.firstName());
        assertEquals(dto.lastName(),studentResponseDto.lastName());
        assertEquals(dto.email(),studentResponseDto.email());

        //Podemos verificar la cantidad de veces que invocamos cada método
        verify(studentMapper,times(1)).toStudent(dto);
        verify(studentRepository,times(1)).save(student);
        verify(studentMapper,times(1)).studentToResponseDto(savedStudent);

    }

    //Queremos verificar que si nos devuelva todos los estudiantes
    @Test
    public void should_return_all_students(){
        //Given
        List<Student> students=new ArrayList<>();
        students.add(new Student("jhon","doe","jhon@mail.com",20));

        //Mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.studentToResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("jhon","doe","jhon@mail.com"));

        //When
        List<StudentResponseDto> responseDtos=studentService.findAllStudents();

        //Then
        assertEquals(students.size(),responseDtos.size());;
    }


    //Tiene que fallar por el email
    @Test
    public void should_return_student_by_id() {
        //Given
        Integer studentId = 1;
        Student student = new Student(
                "jhon",
                "Doe",
                "jhon@mail.com",
                20
        );

        student.setId(1);

        //Mock the calls
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.studentToResponseDto(any(Student.class))).thenReturn(new StudentResponseDto(
                "jhon",
                "Doe",
                "jhon@mail.com"
        ));

        //when
        StudentResponseDto dto = studentService.findStudentById(studentId);

        //then
        assertEquals(dto.firstName(),student.getFirstName());
        assertEquals(dto.lastName(),student.getLastName());
        assertEquals(dto.email(),student.getEmail());

    }

    @Test
    public void should_return_studentResponseDto_by_name(){
        //Given
        String studentName="jhon";
        List<Student> students=new ArrayList<>();
        Student student=new Student(
                "jhon",
                "Doe",
                "jhon@mail.com",
                20
        );
        students.add(student);
        //String studentName=student.getFirstName();

        //Mock the calls
        when(studentRepository.findAllByFirstNameContaining(studentName)).thenReturn(students);
        when(studentMapper.studentToResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("jhon","doe","jhon@mail.com"));

        //when
        var responseDto=studentService.findStudentByName(studentName);

        //then
        assertEquals(students.size(),responseDto.size());

    }



    //public List<StudentResponseDto> findStudentByName(String firstName){
    //        return studentRepository.findAllByFirstNameContaining(firstName).stream().map(studentMapper::studentToResponseDto).collect(Collectors.toList());
    //    }


}