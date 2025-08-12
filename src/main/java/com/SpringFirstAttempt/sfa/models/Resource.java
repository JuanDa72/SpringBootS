package com.SpringFirstAttempt.sfa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

//@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity

//Creo que no podemos hacer una doble herencia, por lo tanto esta clase no heredará de baseEntity

//Tenemos 3 estrategias para heredar pero usaremos la mas sencilla xd
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int size;

    private String url;

}
