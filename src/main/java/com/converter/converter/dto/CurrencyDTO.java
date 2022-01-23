package com.converter.converter.dto;

public class CurrencyDTO {
    private String currency;
    private double amount;

    public CurrencyDTO(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
