package com.example.HW8.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Note {
    //- ID (автоинкрементное)(тип - Long)
    //- Заголовок (не может быть пустым)(тип - String)
    //- Содержимое (не может быть пустым)(тип - String)
    //- Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String dateTime;
}
