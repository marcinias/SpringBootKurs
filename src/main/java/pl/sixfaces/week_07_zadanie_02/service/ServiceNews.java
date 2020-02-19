package pl.sixfaces.week_07_zadanie_02.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sixfaces.week_07_zadanie_02.model.NewsPojo;


@Service
public class ServiceNews {
    private NewsPojo newsInfo;


       public NewsPojo getNewsApi() {

        RestTemplate restTemplate = new RestTemplate();
        newsInfo = restTemplate.getForObject("http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=f373c464b3ec4187b7d83f12a13e0c8e", NewsPojo.class);

         return newsInfo;
    }

}
