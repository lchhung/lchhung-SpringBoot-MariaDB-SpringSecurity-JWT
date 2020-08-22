package com.lchhung.vehicles.web;

import com.lchhung.vehicles.domain.Car;
import com.lchhung.vehicles.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private String a;

    @Autowired
    private CarRepository carRepository;

    @RequestMapping("/cars")

    public Iterable<Car> getCars(){
        //return (carRepository.findByBrand("Ford"));
        return carRepository.findAll();
    }
}
