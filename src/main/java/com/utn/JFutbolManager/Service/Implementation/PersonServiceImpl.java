package com.utn.JFutbolManager.Service.Implementation;

import com.utn.JFutbolManager.Model.Currency;
import com.utn.JFutbolManager.Model.Manager;
import com.utn.JFutbolManager.Model.Person;
import com.utn.JFutbolManager.Model.Player;
import com.utn.JFutbolManager.Repository.IPersonRepository;
import com.utn.JFutbolManager.Service.Interface.IPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {
    private IPersonRepository personRepository;

    public PersonServiceImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getById(Integer personId) {
        return personRepository.findById(personId).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public void addPlayerToManager(Integer managerId, Integer playerId) {
        Manager manager = (Manager) this.getById(managerId);
        Player player = (Player) this.getById(playerId);
        manager.getPlayerList().add(player);
        //ACA SE ACTUALIZA LA GUITA DEL MANAGER
        manager.addMoneyToVault(player.getCurrency());
        personRepository.save(manager);

    }

    @Override
    public void delete(Integer personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public List<Player> getPlayerList(Integer managerId) {
        Manager manager = (Manager) this.getById(managerId);
        return manager.getPlayerList();
    }
}
