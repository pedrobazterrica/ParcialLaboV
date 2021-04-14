package com.utn.JFutbolManager.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//Representante
@Data
@Entity
public class Manager extends Person{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private List<Player> playerList; //jugadores

    private double vaultWeight; //peso de la boveda
    private double totalAmount;

    @Override
    public TypePerson typePerson() {
        return TypePerson.MANAGER;
    }

    public void addMoneyToVault(Currency currency){
        double amount = currency.getAmount();
        this.vaultWeight += amount;
        this.totalAmount += amount * currency.getCurrencyType().getValue();
    }
}
