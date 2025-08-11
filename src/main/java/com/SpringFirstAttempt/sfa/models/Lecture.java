package com.SpringFirstAttempt.sfa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Lecture {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;


    @ManyToOne
    @JoinColumn(
            name = "section_id"
    )
    private Section section;

    @OneToOne
    @JoinColumn(name = "resources_id")
    private Resource resource;


}
