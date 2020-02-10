package pl.sixfaces.home_week_05.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sixfaces.home_week_05.model.City;
import pl.sixfaces.home_week_05.weather.Weather;

@Service
public class ServiceWeather {

    private String url;
    private City city = new City();

    public City getCity() {
        return city;
    }

    RestTemplate restTemplate = new RestTemplate();
    String key = "c66299718662603380bd7501ea00dfee";

    public void getDateCity(String cityName) {

        url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&APPID=" + key;
        System.out.println(url);

        try {
            Weather weatherInfo = restTemplate.getForObject(url, Weather.class);
            city.setNameCity(cityName);
            city.setTemp(weatherInfo.getMain().getTemp());
            city.setIco(weatherInfo.getWeather().get(0).getIcon());
            city.setError("ok");

        } catch (HttpClientErrorException e) {

            city.setError("error");
            city.setNameCity("");


        }

    }

}
