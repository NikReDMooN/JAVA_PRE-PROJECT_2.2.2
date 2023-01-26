package web.controller;

import Model.Car;
import Service.getCars;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CarController {

    Integer MAX_CARS = 5;



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

        List<Car> messageCars = getCars.get(count);

        map.addAttribute("tableList", messageCars);
        map.addAttribute("messages", messageCars);
        return "Cars";
    }

}
