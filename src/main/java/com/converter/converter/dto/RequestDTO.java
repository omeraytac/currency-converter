package com.converter.converter.dto;

public class RequestDTO {
    private String target;
    private String source;
    private double amount;

    public RequestDTO(String target, String source, double amount) {
        this.target = target;
        this.source = source;
        this.amount = amount;
    }

    public String getTarget() {
        return target;
    }

    public String getSource() {
        return source;
    }

    public double getAmount() {
        return amount;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "target='" + target + '\'' +
                ", source='" + source + '\'' +
                ", amount=" + amount +
                '}';
    }
}
