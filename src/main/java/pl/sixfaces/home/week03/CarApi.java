package pl.sixfaces.home.week03;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/cars")
public class CarApi {

    //RepoCars repoCars;
    public List<Car> carList;

    @PostConstruct
    public void ranStart() {

        carList = new ArrayList<>();
        carList.add(new Car(1, "Ford", "C-max", "red"));
        carList.add(new Car(2, "Honda", "Accord", "black"));
        carList.add(new Car(3, "Audi", "A1", "blue"));
        carList.add(new Car(4, "Ford", "S-max", "red"));
        carList.add(new Car(5, "Honda", "Jazz", "black"));
        carList.add(new Car(6, "Audi", "A8", "blue"));

    }


    @GetMapping
    public List<Car> getCars() {
        return carList;
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable int id) {
        Optional<Car> carFound = carList.stream().filter(car -> car.getId() == id).findFirst();
        return carFound.get();

    }


    @GetMapping("color/{color}")
    public List<Car> getCarColor(@PathVariable String color) {

        Predicate<Car> fColor = car -> car.getColor().equalsIgnoreCase(color);

        List<Car> listCars = new ArrayList<>();
        listCars = carList.stream()
                .filter(fColor)
                .collect(Collectors.toList());

        return listCars;

    }


    @PostMapping
    public Car addCar(@RequestBody Car car) {
        carList.add(car);
        return car;
    }


 /*   @PutMapping("/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car newCar) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();

        first.map(car -> {
            carList.remove(first.get());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
            }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

//   dlaczego to nie działa  chce cos zwracac
    }
*/


    @PutMapping("/update")
    public String updateCar(@RequestBody Car newCar) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (first.isPresent()) {

            carList.remove(first.get());
            carList.add(newCar);
            return "added";
        }

        return "not found car";
    }


    @PatchMapping
    public String updateNewCar(@RequestBody Car newCar) {
        return "redirect:/cars";
    }


    @DeleteMapping
    private String removeCar(@RequestBody Car newCar) {

        Optional<Car> first = carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (first.isPresent()) {

            carList.remove(first.get());
            return "remove";
        }

        return "not found car please enter right car ";
    }


}



