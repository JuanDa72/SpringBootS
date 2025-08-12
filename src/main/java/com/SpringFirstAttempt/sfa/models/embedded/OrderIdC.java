package com.SpringFirstAttempt.sfa.models.embedded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

//Usamos embeddable en este caso para generar esta clase que representa la llave compuesta
//embeddable tiene otras utilidades tambien
//Creo que tiene que ser serializable para poder usarlo como llave compuesta
@Embeddable
public class OrderIdC implements Serializable {

    //
    private String username;

    private LocalDateTime orderDate;

}
