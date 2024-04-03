package org.example.services;

import org.example.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Long id, Note note);
    Note createNote(Note note);
    void deleteNote(Long id);
}
