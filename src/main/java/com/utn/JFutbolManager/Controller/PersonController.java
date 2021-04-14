package com.utn.JFutbolManager.Controller;

import com.utn.JFutbolManager.Model.Person;
import com.utn.JFutbolManager.Service.Implementation.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable Integer personId) {
        return personService.getById(personId);
    }

    @PostMapping
    public void addPerson(@RequestBody Person Person) {
        personService.add(Person);
    }

    @PutMapping("/{managerId}/players/{playerId}")
    public void addPlayerToManager(@PathVariable Integer managerId, @PathVariable Integer playerId) {
        personService.addPlayerToManager(managerId, playerId);
    }

    @DeleteMapping("/{personId}")
    public void delete(@PathVariable Integer personId){
        personService.delete(personId);
    }

    @GetMapping("/{managerId}")
    public void getPlayerList(@PathVariable Integer managerId){
        personService.getPlayerList(managerId);
    }
}
