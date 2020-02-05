package pl.sixfaces.week_04_home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);

    public List<Car> carList;


    public CarService() {
        logger.info("Start application ...");
        System.out.println("ssss");
        carList = new ArrayList<>();
        carList.add(new Car(1, "Ford", "C-max", "red"));
        carList.add(new Car(2, "Honda", "Accord", "black"));
        carList.add(new Car(3, "Audi", "A1", "blue"));
        carList.add(new Car(4, "Ford", "S-max", "red"));
        carList.add(new Car(5, "Honda", "Jazz", "black"));
        carList.add(new Car(6, "Audi", "A8", "blue"));

    }


    public List<Car> getCar() {

        return carList;

    }


    public boolean addCar(Car car) {

        if (findCarByID(car.getId()).isPresent()) {
            carList.add(car);
            return true;
        } else
            return false;
    }


    private Optional<Car> findCarByID(int Id) {

        //return carList != null ? carList.stream().filter(c->c.getId() == Id).findFirst() : Optional.empty();
        if (carList != null)
            return carList.stream().filter(c -> c.getId() == Id).findFirst();
        else
            return Optional.empty();


    }


    public Car getCarById(int Id) {
        Optional<Car> car = findCarByID(Id);
        return car.isPresent() != false ? car.get() : car.orElse(null);

    }


    public List<Car> getCarByColo(String color) {

        // Predicate  use

       /* Predicate<Car> fColor = car -> car.getColor().equalsIgnoreCase(color);

        List<Car> listCars = new ArrayList<>();
        listCars = carList.stream()
                .filter(fColor)
                .collect(Collectors.toList());*/

        //map()  use

        List<Car> result = carList.stream().filter(c -> c.getColor().equalsIgnoreCase(color))
                .map(temp -> {
                    Car car = new Car();
                    car.setId(temp.getId());
                    car.setMark(temp.getMark());
                    car.setModel(temp.getModel());
                    car.setColor(temp.getColor());
                    return car;
                }).collect(Collectors.toList());


        return result;

    }

}
