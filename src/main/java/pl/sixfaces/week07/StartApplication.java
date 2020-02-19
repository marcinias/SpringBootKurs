package pl.sixfaces.week07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.sixfaces.week07.model.Car;
import pl.sixfaces.week07.DAO.CarDao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private JdbcTemplate jdbcTemplate;
    private CarDao carDao;
    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    public StartApplication(JdbcTemplate jdbcTemplate, CarDao carDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.carDao = carDao;
    }


    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("Start Application... ");

        runJDBC();
    }


    void runJDBC() {
        log.info("Creating tables for testing...");


        jdbcTemplate.execute("DROP TABLE  IF EXISTS  cars ");

        String sqlTable = "CREATE TABLE cars(" +
                "car_id int(10)  NOT NULL AUTO_INCREMENT, " +
                "mark varchar (255)   NOT NULL ,  " +
                "model varchar (255)  NOT NULL ," +
                "color varchar (255)  NOT NULL , " +
                "date_production date NOT NULL , " +
                "PRIMARY KEY (car_id))";
        jdbcTemplate.execute(sqlTable);


        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", "S-max", "black", Date.valueOf("2000-02-01")));
        cars.add(new Car("Skoda", "Octavia", "red", Date.valueOf("2001-01-04")));
        cars.add(new Car("Audi", "Q2", "withe", Date.valueOf("2020-12-04")));
        cars.add(new Car("Honda", "Jaz", "blue", Date.valueOf("2010-12-04")));
        cars.add(new Car("Ford", "C-max", "black", Date.valueOf("2000-10-04")));


        log.info("[SAVE Car to MySQL]");
        cars.forEach(car -> {
            log.info("Saving.." + car.getMark());
            carDao.saveCar(car);

        });


    }


}
