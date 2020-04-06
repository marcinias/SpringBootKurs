package com.example.mongo_db_week_09;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


@Component
public class Start {


    //  UserRepo userRepo;
    UserRepoHybernate userRepoHybernate;

    @Autowired
    public Start(UserRepoHybernate userRepoHybernate) throws IOException {
        this.userRepoHybernate = userRepoHybernate;
    }


    public Start() throws IOException {

    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() throws IOException {

        List<User> usersList = new Start().readCsvFile();

        long start = System.nanoTime();
        usersList.forEach(user -> {
                    //System.out.println(user);
                    userRepoHybernate.save(user);
                }

        );
        long elapsedTime = System.nanoTime() - start;
        System.out.println("elapsedTime: " + elapsedTime);
        long start02 = System.nanoTime();
        userRepoHybernate.findById(600L);
        long elapsedTime02 = System.nanoTime() - start02;
        System.out.println("elapsedTime02: " + elapsedTime02);
    }


  /*  // opencsv    kolumny z user  ale tylko takie jakie chcę z adnotacją @CsvBindByName w POJO

    public List<User> readCsvFile() throws FileNotFoundException {
        FileReader reader = new FileReader("MOCK_DATA.csv");
        HeaderColumnNameMappingStrategy mappingStrategy = new HeaderColumnNameMappingStrategy();
        mappingStrategy.setType(User.class);
        CsvToBean<User> csvtobean = new CsvToBeanBuilder<User>(reader)
                .withType(User.class)
                .withMappingStrategy(mappingStrategy)
                .withSeparator(',')
                .build();

        return csvtobean.parse();
    }*/


    // opencsv  wszystkie kolumny z user  @CsvBindByPosition(position = 0) w POJO
    public List<User> readCsvFile() throws FileNotFoundException {
        FileReader reader = new FileReader("MOCK_DATA.csv");

        CsvToBean<User> csvtobean = new CsvToBeanBuilder<User>(reader)
                .withType(User.class)
                .withSeparator(',')
                .build();

        return csvtobean.parse();
    }

}

 
