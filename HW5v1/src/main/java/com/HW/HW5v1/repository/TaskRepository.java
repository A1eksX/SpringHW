package com.HW.HW5v1.repository;

import com.HW.HW5v1.TaskStatus;
import com.HW.HW5v1.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByStatus(TaskStatus status);
}
