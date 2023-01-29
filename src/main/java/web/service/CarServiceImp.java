package web.service;

import web.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImp implements CarService {

     private List<Car> allCars;

    public CarServiceImp() {}

    public List<Car> Cars(Integer count) {
        List<Car> serviceCars = new ArrayList<>();
        allCars = new ArrayList<>();
        allCars.add(new Car("BMV","X1", 1990));
        allCars.add(new Car("LADA", "SEDAN", 2020));
        allCars.add(new Car("CHEVROLE ", "MALIBU", 2023));
        allCars.add(new Car("NISSAN", "PRIMERA", 2000));
        allCars.add(new Car("TOYOTA", "COROLLA", 2021));
        for(int i = 0; i < count; i++ ) {
            serviceCars.add(allCars.get(i));
            System.out.println(allCars.get(i));
        }
        return serviceCars;
    }

}
