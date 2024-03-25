package com.HW.HW5v1.repository;

import com.HW.HW5v1.TaskStatus;
import com.HW.HW5v1.model.Task;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByStatus(TaskStatus status);     // TaskStatus status
//    @Modifying
//    @Query("UPDATE tasks SET status = :status WHERE id = :id")
//    Task updateTaskStatus(long id, Task task);

}
