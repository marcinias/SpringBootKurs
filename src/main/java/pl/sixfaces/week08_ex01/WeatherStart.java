package pl.sixfaces.week08_ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.sixfaces.week08_ex01.model.City;
import pl.sixfaces.week08_ex01.repository.WeatherRepo;
import pl.sixfaces.week08_ex01.service.ServiceWeather;

@Component
public class WeatherStart {

    String nameCity = "London";
    private ServiceWeather service;
    private WeatherRepo weatherRepo;

    @Autowired
    public WeatherStart(ServiceWeather service, WeatherRepo weatherRepo) {
        this.service = service;
        this.weatherRepo = weatherRepo;
    }

      //@Scheduled(cron ="0 * * * * *" ) // every min
     // @Scheduled(cron ="0 0 * * * *" ) // every hour
     @Scheduled(fixedDelay = 1000)//every  second
    void start() {
        City city = service.getDateCity(nameCity);
        weatherRepo.save(city);
        System.out.println(city);
    }

}

