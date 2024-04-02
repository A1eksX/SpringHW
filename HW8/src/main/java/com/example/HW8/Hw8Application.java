package com.example.HW8;

import com.example.HW8.configuration.ProjectConfiguration;
import com.example.HW8.model.Note;
import com.example.HW8.services.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Hw8Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw8Application.class, args);
	}

}
