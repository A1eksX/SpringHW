package com.HW.HW5v1.model;


import com.HW.HW5v1.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "tasks")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;
    //  --------------------------------------
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;


}
