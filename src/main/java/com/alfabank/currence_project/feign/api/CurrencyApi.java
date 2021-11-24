package com.alfabank.currence_project.feign.api;


import com.alfabank.currence_project.model.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "currencyApi", url = "${currency}")
public interface CurrencyApi {

    @GetMapping("${latest}" + "?app_id=${app_id}" + "&base=${base}")
    Currency getLatestCurrency();

    @GetMapping("/${historical}" + "?app_id=${app_id}" + "&base=${base}")
    Currency getHistoricalCurrency();

}
