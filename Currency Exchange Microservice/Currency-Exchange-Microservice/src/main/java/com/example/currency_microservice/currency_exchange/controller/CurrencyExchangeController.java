package com.example.currency_microservice.currency_exchange.controller;


import com.example.currency_microservice.currency_exchange.models.CurrrencyExchangeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {


    @Autowired
    private Environment environment;



    @GetMapping("from/{from}/to/{to}")
    public CurrrencyExchangeModel getCurrencyExchange(@PathVariable String from,
                                                      @PathVariable String to){

        String env = environment.getProperty("local.server.port");


        CurrrencyExchangeModel currrencyExchangeModel =  new CurrrencyExchangeModel(
                10001,
                from,
                to,
                new BigDecimal("12.0")
        );
        currrencyExchangeModel.setEnvironment(env);
        return currrencyExchangeModel;
    }
}
