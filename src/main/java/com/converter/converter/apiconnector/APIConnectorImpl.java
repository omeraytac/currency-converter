package com.converter.converter.apiconnector;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

@Component
public class APIConnectorImpl implements APIConnector{

    @Override
    public ArrayList<Double> getExchangeRate(String source, String target) {
        Map rates = get_rates_from_api(source,target);
        if(rates.size() < 2){
            return null;
        }
        ArrayList<Double> results = new ArrayList<>();
        results.add(0,cast_to_double(rates,source));
        results.add(1,cast_to_double(rates,target));
        System.out.println(results.toString());
        return results;
    }

    private double cast_to_double(Map rates, String currency){
        if(rates.get(currency) instanceof Integer){
            int temp = (int)rates.get(currency);
            return (double)temp;
        }
        else{
            return (double)rates.get(currency);
        }
    }

    private Map get_rates_from_api(String source, String target){
        // "http://api.exchangeratesapi.io/v1/latest?access_key=3e3e11716557abe2b814bd618081f1ec&symbols="
        String url = APIConstants.baseUrl + APIConstants.latest + "?" + APIConstants.access_key + APIConstants.key +
                "&" + APIConstants.symbols + source + "," + target;
        Map result = null;
        Map rates = null;
        try {
            result = new RestTemplate().getForObject(url, Map.class);
            rates = (Map) result.get("rates");
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        System.out.println("result is " + result);
        return rates;
    }
}
