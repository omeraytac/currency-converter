package com.converter.converter.calculator;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator{

    @Override
    public double calculate(double source, double target, double amount) {
        return (target*amount)/source;
    }
}
