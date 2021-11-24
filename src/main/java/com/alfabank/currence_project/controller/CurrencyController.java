package com.alfabank.currence_project.controller;


import com.alfabank.currence_project.feign.api.CurrencyApi;
import com.alfabank.currence_project.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    private final CurrencyApi currencyApi;

    public CurrencyController(CurrencyApi currencyApi) {
        this.currencyApi = currencyApi;
    }

    @GetMapping("/gif")
    public ModelAndView getLatestCurrency() {
        double today = currencyService.getCurrency(currencyApi.getLatestCurrency());
        double yesterday = currencyService.getCurrency(currencyApi.getHistoricalCurrency());
        String urlGif = currencyService.getGif(today, yesterday);
        return new ModelAndView("redirect:" + urlGif);
    }


}
