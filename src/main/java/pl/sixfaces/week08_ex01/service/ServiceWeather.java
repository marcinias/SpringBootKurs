package pl.sixfaces.week08_ex01.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sixfaces.week08_ex01.model.City;
import pl.sixfaces.week08_ex01.model.weather.Weather;
import java.time.*;
import java.time.format.DateTimeFormatter;


@Service
public class ServiceWeather {

    private String url;


    RestTemplate restTemplate = new RestTemplate();
    String key = "c66299718662603380bd7501ea00dfee";

    public City getDateCity(String cityName) {

        url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&APPID=" + key;
        Weather weatherInfo = restTemplate.getForObject(url, Weather.class);

        // Offset UTC
        Integer secondsOffsetUTC = weatherInfo.getTimezone();
        ZoneOffset timeOffsetSec = ZoneOffset.ofTotalSeconds(secondsOffsetUTC);
        OffsetDateTime offsetDateTime = OffsetDateTime.now(timeOffsetSec);
        String dateFormat = offsetDateTime.format(DateTimeFormatter.RFC_1123_DATE_TIME);
        //
        String icon = weatherInfo.getWeather().get(0).getIcon();
        Double temp = weatherInfo.getMain().getTemp();

        City city = new City(cityName, icon, "ok", temp, dateFormat);

        return city;


    }

}
