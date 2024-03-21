package ru.HW.HW4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Task1Controller {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
