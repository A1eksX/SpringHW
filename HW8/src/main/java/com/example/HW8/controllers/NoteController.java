package com.example.HW8.controllers;

import com.example.HW8.model.Note;
import com.example.HW8.services.NoteService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/")
public class NoteController {

    private final NoteService service;


    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes(){
        return new ResponseEntity<>(service.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findNoteById(@PathVariable("id") Long id){
        Note note;
        try{
            note = service.getNoteById(id);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Такого id не существует");
        }
        return new ResponseEntity<>(service.getNoteById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        return new ResponseEntity<>(service.updateNote(id, note), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") Long id){
        try {
            service.deleteNote(id);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Такого id не существует");
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
