package ru.HW.HW4.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.HW.HW4.models.Car;
import ru.HW.HW4.services.CarService;


@Controller
@Log
//@AllArgsConstructor
public class Task3Controller {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(Model model){
        model.addAttribute("cars",  carService.getAllCar());
        log.info("метод getCars выполнен");
        return "cars";
    }
    @PostMapping("/cars")
    public String addCar(Car car, Model model){
        carService.addCar(car);
        log.info("добавлен автомобиль: " + car.getModel());
        model.addAttribute("cars", carService.getAllCar());
        return "redirect:/cars";
    }

}
