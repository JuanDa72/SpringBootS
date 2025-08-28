package com.SpringFirstAttempt.sfa.securitySecTry;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    //Definimos un enum para el tokenType, de modo que sea de tipo bearer por si posteriormente
    //a alguien le interesa y como una buena práctica por si quizá en el futuro se agregan los otros tipo
    //de token xd

    public enum TokenType{
        BEARER
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    //Con enumerated definimos explicitamente como guardamos el enum en la base de datos
    @Builder.Default
    //Con builder default indicamos que el builder de lombok genere correctamente este valor por defecto
    //y podamos usar getter para este atributo
    private TokenType tokenType=TokenType.BEARER;

    //Indica si el token fue revocado por logout, actividad sospechosa o si el admin
    @Column(nullable = false)
    private Boolean isRevoked;

    //Indica si ya llego o supero su fecha de expiración
    @Column(nullable = false)
    private Boolean isExpired;

    @ManyToOne(fetch = FetchType.LAZY)
    //indicamos que tenemos muchos token por un usuario y que ademas no traiga el user completo al que pertenece
    //a menos que user el getter
    @JoinColumn(name = "user2_id")
    //Con joinColumn indicamos que esta será la llave foranea
    private User2 user;


}
