package com.SpringFirstAttempt.sfa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Section {

    @Id
    @GeneratedValue
    private Integer id;

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
