package pl.sixfaces.week_07_zadanie_02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.sixfaces.week_07_zadanie_02.DAO.NewsDao;
import pl.sixfaces.week_07_zadanie_02.model.Article;
import pl.sixfaces.week_07_zadanie_02.service.ServiceNews;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Week07Zadanie02Application implements CommandLineRunner {

    private JdbcTemplate jdbcTemplate;
    private ServiceNews serviceNews;
    private NewsDao newsDao;


    private static final Logger log = LoggerFactory.getLogger(Week07Zadanie02Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Week07Zadanie02Application.class, args);
    }

    @Autowired
    public Week07Zadanie02Application(JdbcTemplate jdbcTemplate, ServiceNews serviceNews, NewsDao newsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.serviceNews = serviceNews;
        this.newsDao = newsDao;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start Application... ");

        runJDBC();
    }


    void runJDBC() {
        log.info("Creating tables for testing...Table");


        jdbcTemplate.execute("DROP TABLE  IF EXISTS  news ");

        String sqlTable = "CREATE TABLE news(" +
                "news_id int(10)  NOT NULL AUTO_INCREMENT, " +
                "title varchar (255)   NOT NULL ,  " +
                "description TEXT  NOT NULL ," +
                "url varchar (555)  NOT NULL , " +
                "PRIMARY KEY (news_id))";
        jdbcTemplate.execute(sqlTable);

        log.info("[SAVE News to MySQL]");

        List<Article> sources = new ArrayList<>();
        sources.addAll(serviceNews.getNewsApi().getArticles());
        sources.forEach(news -> newsDao.saveNews(news));


    }
}
