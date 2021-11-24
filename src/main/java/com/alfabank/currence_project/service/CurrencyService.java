package com.alfabank.currence_project.service;

import com.alfabank.currence_project.model.Currency;
import com.alfabank.currence_project.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    Gif gif;

    public double getCurrency(Currency currency){
        Map<String, Double> rates = currency.getRates();
        return rates.get("RUB");
    }

    public String getGif(double today, double yesterday){
        StringBuilder builder = new StringBuilder();

        if (today > yesterday) {
            builder.append(gif.getUpQuotes());
        } else {
            builder.append(gif.getLowQuotes());
        }

        return builder.toString();
    }

}
