package pl.sixfaces.week07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sixfaces.week07.model.Car;
import pl.sixfaces.week07.DAO.CarDaoImpl;
import pl.sixfaces.week07.model.DateCarProductionSearch;

import java.util.List;


@Controller
public class CarController {

    private CarDaoImpl carDao;
    private List<Car> byDateBetween;

    private DateCarProductionSearch dateSearchObject = new DateCarProductionSearch();

    @Autowired
    CarController(CarDaoImpl carDao) {
        this.carDao = carDao;
    }


    @GetMapping
    public String allCars(Model model) {

        List<Car> carList = carDao.findAll();
        model.addAttribute("cars", carList);
        model.addAttribute("searchCar", dateSearchObject);

        if (byDateBetween == null) {
            model.addAttribute("findCars", new Car());
        } else {
            model.addAttribute("findCars", byDateBetween);
        }
        return "index";
    }


    @GetMapping("/carSearch")
    public String searchCar(@RequestParam("dateFrom") String dateFrom,
                            @RequestParam("dateTo") String dateTo, Model model) {
        dateSearchObject.setDateFrom(dateFrom);
        dateSearchObject.setDateTo(dateTo);
        byDateBetween = carDao.findByDateBetween(dateFrom, dateTo);
        model.addAttribute("findCars", byDateBetween);
        return "redirect:/";
    }


}
