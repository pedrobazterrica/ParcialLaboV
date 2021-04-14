package com.utn.JFutbolManager.Controller;

import com.utn.JFutbolManager.Model.Currency;
import com.utn.JFutbolManager.Service.Implementation.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private final CurrencyServiceImpl CurrencyService;

    public CurrencyController(CurrencyServiceImpl CurrencyService) {
        this.CurrencyService = CurrencyService;
    }

    @GetMapping
    public List<Currency> getAll() {
        return CurrencyService.getAll();
    }

    @GetMapping("/{CurrencyId}")
    public Currency getCurrencyById(@PathVariable Integer CurrencyId) {
        return CurrencyService.getById(CurrencyId);
    }

    @PostMapping
    public void addCurrency(@RequestBody Currency Currency) {
        CurrencyService.add(Currency);
    }

    @DeleteMapping("/{CurrencyId}")
    public void delete(@PathVariable Integer CurrencyId){
        CurrencyService.delete(CurrencyId);
    }

}