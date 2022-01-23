package com.converter.converter.service;

import com.converter.converter.apiconnector.APIConnectorImpl;
import com.converter.converter.calculator.CalculatorImpl;
import com.converter.converter.dto.CurrencyDTO;
import com.converter.converter.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CalculatorImpl calculator;
    @Autowired
    private APIConnectorImpl apiConnector;

    @Override
    public CurrencyDTO convert(RequestDTO requestDTO) {
        System.out.println(requestDTO.toString());
        ArrayList<Double> rates = apiConnector.getExchangeRate(requestDTO.getSource(), requestDTO.getTarget());
        if(rates == null){
            return null;
        }
        double result = calculator.calculate(rates.get(0),rates.get(1),requestDTO.getAmount());
        return new CurrencyDTO(requestDTO.getTarget(),result);
    }
}
