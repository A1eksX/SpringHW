package ru.HW.HW4.services;

import org.springframework.stereotype.Service;
import ru.HW.HW4.models.Car;


import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car){
        cars.add(car);
    }

    public List<Car> getAllCar(){
        return cars;
    }
}
