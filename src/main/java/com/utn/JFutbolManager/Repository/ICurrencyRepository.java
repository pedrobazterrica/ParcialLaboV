package com.utn.JFutbolManager.Repository;

import com.utn.JFutbolManager.Model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface ICurrencyRepository extends JpaRepository<Currency, Integer> {

}
