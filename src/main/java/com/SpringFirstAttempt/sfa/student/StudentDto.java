package com.SpringFirstAttempt.sfa.student;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record StudentDto(

        @NotEmpty(message = "FirstName should not be empty")
        String firstName,

        @NotEmpty(message = "LastName should not be empty")
        String lastName,

        String email,

        Integer schoolId


) {

}
