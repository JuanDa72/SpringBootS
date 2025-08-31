package com.SpringFirstAttempt.sfa.securitySecTry;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Builder
//La anotación builder es útil ya que nos permite crear objetos de tipo user2 de forma mas legible e
//incluso crear builders personalizados (no en este caso) para poner por ejemplo, el manejo de excepciones o tambien
//el uso de valores por defecto

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user2")
public class User2 {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;


}
