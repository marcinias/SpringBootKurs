package pl.sixfaces.home.week03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;




@RestController


@RequestMapping(value = "/cars", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
public class CarApi {

    RepoCars repoCars;


    @Autowired
    public CarApi(RepoCars repoCars) {
        this.repoCars = repoCars;
    }


    @GetMapping
    private RepoCars getCars() {
        return repoCars;
    }

    @GetMapping("/{id}")
    private Car getCar(@PathVariable int id) {
        Optional<Car> carFound = repoCars.carList.stream().filter(car -> car.getId() == id).findFirst();
        return carFound.get();

    }


    @GetMapping("color/{color}")
    private List<Car> getCarColor(@PathVariable String color) {

        Predicate<Car> fColor = car -> car.getColor().equalsIgnoreCase(color);

        List<Car> listCars = new ArrayList<>();
        listCars = repoCars.carList.stream()
                .filter(fColor)
                .collect(Collectors.toList());

        return listCars;

    }

    @PostMapping
    private Car addCar(@RequestBody Car car) {
        repoCars.carList.add(car);
        return car;
    }


    @PutMapping
    private String updateCar(@RequestBody Car newCar) {
        return updateNewCarList(newCar);
    }


    @PatchMapping
    private String updateNewCar(@RequestBody Car newCar) {
        return updateNewCarList(newCar);
    }


    @DeleteMapping
    private String removeCar(@RequestBody Car newCar) {

        Optional<Car> first = repoCars.carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (first.isPresent()) {

            repoCars.carList.remove(first.get());
            return "remove";
        }

        return "not found car please enter right car ";
    }


    private String updateNewCarList(@RequestBody Car newCar) {
        Optional<Car> first = repoCars.carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (first.isPresent()) {

            repoCars.carList.remove(first.get());
            repoCars.carList.add(newCar);
            return "added";
        }

        return "not found car";
    }


}



