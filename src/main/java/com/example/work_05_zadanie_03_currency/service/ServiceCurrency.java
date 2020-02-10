package com.example.work_05_zadanie_03_currency.service;

import com.example.work_05_zadanie_03_currency.model.CurrencyNew;
import com.example.work_05_zadanie_03_currency.model.MyCurrency;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCurrency {
    private double USD;
    private int i;
    private MyCurrency myCurrency = new MyCurrency();

    public MyCurrency getMyCurrency() {
        return myCurrency;
    }

    public ServiceCurrency() {

        RestTemplate currencyRest = new RestTemplate();
        CurrencyNew ratesForObject = currencyRest.getForObject("https://api.ratesapi.io/api/latest?base=USD&symbols=PLN", CurrencyNew.class);

        USD = Math.round(ratesForObject.getRates().getPLN() * 100.0) / 100.0;
        myCurrency.setUsd(USD);

    }

    public void check(double usdInput) {
        i++;
        myCurrency.setUsdInput(usdInput);
        myCurrency.setCounter(i);

        if (myCurrency.getUsd() < usdInput) {
            myCurrency.setStatus(" Wrong ! too high a value Try again  ");
        } else if (myCurrency.getUsd() > usdInput) {
            myCurrency.setStatus(" Wrong ! too low value Try again  ");
        } else {
            myCurrency.setStatus("ok");
        }
    }


}
