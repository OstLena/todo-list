package com.goit.todolist.service;

import com.goit.todolist.exception.ExceptionToFindNoteById;
import com.goit.todolist.model.Note;
import com.goit.todolist.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public Iterable<Note> listAll() {
        return noteRepository.findAll();
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        getById(note.getId());
        noteRepository.save(note);
    }

    public Note getById(long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return note.get();
        } else {
            throw new ExceptionToFindNoteById(id);
        }
    }
}
