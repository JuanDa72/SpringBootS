package com.SpringFirstAttempt.sfa.school;

import com.SpringFirstAttempt.sfa.school.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
