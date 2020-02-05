package pl.sixfaces.week_04_home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class CarApi {

    CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(ModelMap model) {
        System.out.println("/index");
        List<Car> cars = carService.getCar();

        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        model.addAttribute("searchCar", new Car());


        return "index";
    }


    @PostMapping("/add")
    public String addCar(Car car) {

        System.out.println("/add");
        carService.carList.add(car);
        return "redirect:/";
    }


    @GetMapping("/delete")
    private String removeCar(@RequestParam("Id") int Id) {
        System.out.println("/delete");
        Optional<Car> first = carService.carList.stream().filter(car -> car.getId() == Id).findFirst();
        if (first.isPresent())
            carService.carList.remove(first.get());
        return "redirect:/";
    }


    @GetMapping("/update/form")
    public String updateCarForm(@RequestParam("Id") int Id, ModelMap model) {

        System.out.println("/update/form");
        Optional<Car> first = carService.carList.stream().filter(car -> car.getId() == Id).findFirst();
        model.addAttribute("updateCar", first.get());
        Car carUpdate = first.get();
        return "update";

    }

    @PostMapping("/update/save")
    public String updateCar(Car carUpdate) {
        System.out.println("/update/save");
        Optional<Car> first = carService.carList.stream().filter(car -> car.getId() == carUpdate.Id).findFirst();

        if (first.isPresent()) {
            carService.carList.remove(first.get());
            carService.carList.add(carUpdate);
        }
        return "redirect:/";

    }

    @GetMapping("/carSearch")
    public String changeCarByColor(@RequestParam("color") String color, ModelMap model) {

       List<Car> carFindList =  carService.getCarByColo(color);
        System.out.println("/search id: " + color+ "  car:   " + carFindList );
        model.addAttribute("car", carFindList );
        return "list-search";


    }


}



