package com.HW.HW5v1.controllers;

import com.HW.HW5v1.TaskStatus;
import com.HW.HW5v1.model.Task;
import com.HW.HW5v1.services.TaskService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TaskController {

    private TaskService service;
    private final Counter requestCounter = Metrics.counter("request_count");


    @PostMapping
    public void addTask(@RequestBody Task task){

        requestCounter.increment();
        service.addTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return service.getAllTask();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable("status") TaskStatus status){
        return service.findTaskByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return service.updateTaskStatus(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }

}
