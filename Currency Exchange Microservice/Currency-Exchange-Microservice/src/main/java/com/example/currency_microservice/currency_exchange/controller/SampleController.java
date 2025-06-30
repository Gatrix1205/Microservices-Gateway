package com.example.currency_microservice.currency_exchange.controller;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {

    private Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("sample-api")
    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedRes")
    @RateLimiter(name = "default")
    @Bulkhead(
            name = "default"
    )
    public String sample(){
        logger.info("Sample API");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost/8080", String.class);
        return  forEntity.getBody();
    }

    private String hardCodedRes(Exception ex){
        return "HardCoded Res";
    }
}
