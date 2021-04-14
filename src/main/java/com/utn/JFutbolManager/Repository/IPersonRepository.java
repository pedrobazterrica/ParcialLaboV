package com.utn.JFutbolManager.Repository;

import com.utn.JFutbolManager.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface IPersonRepository extends JpaRepository<Person, Integer> {
}
