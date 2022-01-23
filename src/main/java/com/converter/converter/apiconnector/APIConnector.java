package com.converter.converter.apiconnector;

import java.util.ArrayList;

public interface APIConnector {
    public ArrayList<Double> getExchangeRate(String source, String target);
}
