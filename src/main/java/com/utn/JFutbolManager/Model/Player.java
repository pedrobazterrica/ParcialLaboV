package com.utn.JFutbolManager.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Player extends Person{
    private double weight;
    private double height;
    private Integer goals;
    private double minutesPlayed;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private Currency currency; //crear enum
    private LocalDate birthdate;

    @Override
    public TypePerson typePerson() {
        return TypePerson.PLAYER;
    }
}
