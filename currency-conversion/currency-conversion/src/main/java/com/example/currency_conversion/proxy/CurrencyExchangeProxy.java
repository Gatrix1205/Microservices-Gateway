package com.example.currency_conversion.proxy;


import com.example.currency_conversion.entity.CurrencyConversionModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




//@FeignClient(value = "currency-exchange", url = "localhost:8001")

/// For load balancing, remove the hardcoded URL feignclient and eureka will handle it automatically
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionModel getCurrencyExchange(@PathVariable String from,
                                                @PathVariable String to);
}
