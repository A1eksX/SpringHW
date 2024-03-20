package com.example.sem3_HomeTask.controllers;

import com.example.sem3_HomeTask.domain.User;
import com.example.sem3_HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUserByAge(){
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    // filterUsersByAge
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        return service.filterUserByAge(service.getRepository().getUsers(), age);
    }

    // calculateAverageAge
    @GetMapping("/calc")
    public double calculateAverageAge (){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
