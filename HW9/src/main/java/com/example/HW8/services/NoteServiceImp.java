package com.example.HW8.services;

import com.example.HW8.aspects.TrackUserAction;
import com.example.HW8.model.Note;
import com.example.HW8.repository.NoteRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class NoteServiceImp implements NoteService{
    private final NoteRepository repository;


    @Override
    @TrackUserAction
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    @TrackUserAction
    public Note updateNote(Long id, Note note) {
        Note newNote = getNoteById(id);
        newNote.setTitle(note.getTitle());
        newNote.setContent(note.getContent());
        return repository.save(newNote);
    }

    @Override
    @TrackUserAction
    public Note createNote(Note note) {
        DateTimeFormatter FORMATER =DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        LocalDateTime dateTime = LocalDateTime.now();
        String time = dateTime.format(FORMATER);
        note.setDateTime(time);
        return repository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        repository.delete(getNoteById(id));
    }
}
