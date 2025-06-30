package com.example.currency_conversion.controller;


import com.example.currency_conversion.entity.CurrencyConversionModel;
import com.example.currency_conversion.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;


    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionModel getCurrencyConversion(@PathVariable String from, @PathVariable String to,

                                                         @PathVariable BigDecimal quantity) {

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionModel> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversionModel.class, uriVariables
        );

        CurrencyConversionModel currencyConversionModel = responseEntity.getBody();
        if (currencyConversionModel == null) {
            return null;
        }


        return new CurrencyConversionModel(
                currencyConversionModel.getId(),
                from,
                to,
                currencyConversionModel.getConversionValue(),
                quantity,
                currencyConversionModel.getConversionValue().multiply(quantity),
                currencyConversionModel.getEnvironment()
        );
    }


    @GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionModel getCurrencyConversionWithFeigh(@PathVariable String from, @PathVariable String to,

                                                                  @PathVariable BigDecimal quantity) {

        CurrencyConversionModel currencyConversionModel = currencyExchangeProxy.getCurrencyExchange(from, to);


        return new CurrencyConversionModel(
                currencyConversionModel.getId(),
                from,
                to,
                currencyConversionModel.getConversionValue(),
                quantity,
                currencyConversionModel.getConversionValue().multiply(quantity),
                currencyConversionModel.getEnvironment()
        );
    }
}
