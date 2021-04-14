package com.utn.JFutbolManager.Service.Implementation;


import com.utn.JFutbolManager.Model.Currency;
import com.utn.JFutbolManager.Repository.ICurrencyRepository;
import com.utn.JFutbolManager.Service.Interface.ICurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyServiceImpl implements ICurrencyService {
    private ICurrencyRepository currencyRepository;

    @Override
    public void add(Currency currency) {
        currencyRepository.save(currency);
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency getById(Integer currencyId) {
        return currencyRepository.findById(currencyId).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public void delete(Integer currencyId) {
        currencyRepository.deleteById(currencyId);
    }

}
