package com.example.HW8.configuration;

import com.example.HW8.aspects.LoggingAspect;
//import com.example.HW8.model.NewNote;
import com.example.HW8.repository.NoteRepository;
//import com.example.HW8.services.NewNoteService;
import com.example.HW8.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example.HW8")
@EnableAspectJAutoProxy
@AllArgsConstructor
public class ProjectConfiguration {

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
