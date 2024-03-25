package com.HW.HW5v1.services;

import com.HW.HW5v1.TaskStatus;
import com.HW.HW5v1.exceptions.TaskNotFoundException;
import com.HW.HW5v1.model.Task;
import com.HW.HW5v1.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
//    @Autowired
    private TaskRepository repository;


    public Task addTask(Task task){
        return repository.save(task);
    }

    public List<Task> getAllTask(){
        return repository.findAll();
    }
    public List<Task> findTaskByStatus(TaskStatus status) {      // TaskStatus status
        return repository.findTaskByStatus(status);
    }
    //  ----------------------------------------

    public Optional<Task> getTaskById(Long id){
        return repository.findById(id);
    }

    public Task updateTaskStatus(long id, Task task){
        Optional<Task> optionalTask = getTaskById(id);
        if (optionalTask.isPresent()){
            Task updateTask = optionalTask.get();
            updateTask.setStatus(task.getStatus());
            return repository.save(updateTask);
        }else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public void deleteTask(long id){
        repository.deleteById(id);
    }

}
