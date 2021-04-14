package com.utn.JFutbolManager.Service.Interface;

import com.utn.JFutbolManager.Model.Currency;

import java.util.List;

public interface ICurrencyService {
    public void add(Currency currency);
    public List<Currency> getAll();
    public Currency getById(Integer currencyId);
    public void delete(Integer CurrencyId);
    public List<Currency> getPlayerList(Integer managerId);
}
