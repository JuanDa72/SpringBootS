package com.SpringFirstAttempt.sfa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Section extends BaseEntity{

    private String name;

    private int sectionOrder;

    //Con esto indicamos que la llave foranea la ponemos en esta entidad y no en cursos
    @ManyToOne
    @JoinColumn(
            name = "courses_id"
    )
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;

}
