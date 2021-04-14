package com.utn.JFutbolManager.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor

//Esto es para poder tener los hijos en el json
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typePerson", visible = true)
@JsonSubTypes({     //Todas las subclases
        @JsonSubTypes.Type(value = Manager.class, name = "MANAGER"),
        @JsonSubTypes.Type(value = Player.class, name = "PLAYER"),
})
@Entity
public abstract class Person {
    @Id
    @GeneratedValue
    private Integer Id;

    @NotNull(message = "Name must have a value")
    private String name;

    @NotNull(message = "lastName must have a value")
    private String lastName;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypePerson typePerson();      //Override en los hijos devuelvan el tipo que son
}
