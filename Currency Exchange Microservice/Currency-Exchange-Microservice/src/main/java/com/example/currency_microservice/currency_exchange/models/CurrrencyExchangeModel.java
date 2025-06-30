package com.example.currency_microservice.currency_exchange.models;


import java.math.BigDecimal;


public class CurrrencyExchangeModel {

    public int id;

    public String fromName;

    public String toName;

    public BigDecimal conversionValue;

    public String environment;

    public CurrrencyExchangeModel(int id, String fromName, String toName, BigDecimal conversionValue) {
        this.id = id;
        this.fromName = fromName;
        this.toName = toName;
        this.conversionValue = conversionValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getConversionValue() {
        return conversionValue;
    }

    public String getToName() {
        return toName;
    }

    public String getFromName() {
        return fromName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public void setConversionValue(BigDecimal conversionValue) {
        this.conversionValue = conversionValue;
    }


}
