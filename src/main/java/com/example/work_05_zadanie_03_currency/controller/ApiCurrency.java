package com.example.work_05_zadanie_03_currency.controller;


import com.example.work_05_zadanie_03_currency.service.ServiceCurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ApiCurrency {

    private ServiceCurrency serviceCurrency;

    @Autowired
    public ApiCurrency(ServiceCurrency serviceCurrency) {
        this.serviceCurrency = serviceCurrency;
    }

    @GetMapping
    public String getGame(Model model) {
        model.addAttribute("currency", serviceCurrency.getMyCurrency());

        return "index";
    }

    @GetMapping("/check")
    public String getCheck(@RequestParam("usdInput") double usdInput, Model model) {
        serviceCurrency.check(usdInput);
        model.addAttribute("currency", serviceCurrency.getMyCurrency());

        return "redirect:/";
    }

}
