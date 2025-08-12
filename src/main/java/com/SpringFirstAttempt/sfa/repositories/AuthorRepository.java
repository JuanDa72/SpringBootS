package com.SpringFirstAttempt.sfa.repositories;

import com.SpringFirstAttempt.sfa.models.Author;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {



}
