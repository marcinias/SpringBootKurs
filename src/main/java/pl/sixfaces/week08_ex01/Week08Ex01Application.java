package pl.sixfaces.week08_ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class Week08Ex01Application {

    public static void main(String[] args) {
        SpringApplication.run(Week08Ex01Application.class, args);
    }

}
