package pl.sixfaces.home_week_05.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sixfaces.home_week_05.model.City;
import pl.sixfaces.home_week_05.service.ServiceWeather;


@Controller
public class WeatherController {

    private ServiceWeather service;

    @Autowired
    public WeatherController(ServiceWeather service) {
        this.service = service;
    }

    @GetMapping
    public String start(ModelMap model) {
        model.addAttribute("search", new City());

        return "index";

    }

    @GetMapping("/citySearch")
    public String getCity(@RequestParam("nameCity") String nameCity, ModelMap model) {
        service.getDateCity(nameCity);
        model.addAttribute("city", service.getCity());

        return "search";

    }

}

