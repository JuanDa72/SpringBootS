package com.SpringFirstAttempt.sfa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Colocamos <Entidad, tipo de dato del id>
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstNameContaining(String firstName);


}
