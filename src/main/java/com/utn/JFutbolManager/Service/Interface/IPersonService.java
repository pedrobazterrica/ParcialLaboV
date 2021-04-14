package com.utn.JFutbolManager.Service.Interface;

import com.utn.JFutbolManager.Model.Person;
import com.utn.JFutbolManager.Model.Player;

import java.util.List;

public interface IPersonService {
    public void add(Person person);
    public List<Person> getAll();
    public Person getById(Integer personId);
    public void addPlayerToManager(Integer managerId, Integer playerId);
    public void delete(Integer personId);
    public List<Player> getPlayerList(Integer managerId);
}
