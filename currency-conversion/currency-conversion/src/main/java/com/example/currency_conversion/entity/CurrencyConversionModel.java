package com.example.currency_conversion.entity;



import java.math.BigDecimal;


public class CurrencyConversionModel {

    public int id;
    public String fromName;
    public String toName;
    public BigDecimal conversionValue;
    public BigDecimal quantity;
    public BigDecimal totalCalculatedAmount;
    public String environment;

    public CurrencyConversionModel(int id, String fromName,
                                   String toName,
                                   BigDecimal conversionValue,
                                   BigDecimal quantity,
                                   BigDecimal totalCalculatedAmount,
                                   String environment) {
        this.id = id;
        this.fromName = fromName;
        this.toName = toName;
        this.conversionValue = conversionValue;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }
    public int getId() {
        return id;
    }

    public String getFromName() {
        return fromName;
    }

    public String getToName() {
        return toName;
    }

    public BigDecimal getConversionValue() {
        return conversionValue;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFrom(String from) {
        this.fromName = from;
    }

    public void setMyto(String myto) {
        this.toName = myto;
    }

    public void setConversionValue(BigDecimal conversionMultiple) {
        this.conversionValue = conversionMultiple;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }


}

