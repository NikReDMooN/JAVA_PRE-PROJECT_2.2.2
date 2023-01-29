package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    Integer MAX_CARS = 5;


    CarService carService;


    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(required = false) Integer count, ModelMap map) {


        if (count == null) {
            count = MAX_CARS;
        }
        if (count > MAX_CARS) {
            count = MAX_CARS;
        }
        if (count < 0) {
            count = 0;
        }
        System.out.println("count = " + count);

        List<Car> messageCars = carService.Cars(count);
        map.addAttribute("tableList", messageCars);
        return "Cars";
    }

}
