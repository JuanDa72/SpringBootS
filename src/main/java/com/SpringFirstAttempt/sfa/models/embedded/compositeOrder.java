package com.SpringFirstAttempt.sfa.models.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class compositeOrder {

    @EmbeddedId
    private OrderIdC id;

    //Segundo uso para @Embeddable, en este caso usamos esto para incluir como atributos/
    //columnas los atributos de la tabla @Embeddable que NO usamos como entidad
    @Embedded
    private Address address;

    private String orderInfo;

    private String anotherField;

}
