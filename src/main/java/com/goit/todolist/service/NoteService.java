package com.goit.todolist.service;

import com.goit.todolist.exception.ExceptionToFindNoteById;
import com.goit.todolist.model.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {

    private final AtomicLong counter = new AtomicLong();

    private final Map<Long, Note> notesMap = new HashMap<>();

    public Note add(Note note) {
        long uniqueLong = counter.incrementAndGet();
        note.setId(uniqueLong);
        return notesMap.put(uniqueLong, note);
    }

    public List<Note> listAll() {
        return notesMap.values().stream().toList();
    }

    public void deleteById(long id) {
        notesMap.remove(id);
    }

    public void update(Note note) {
        Note update = notesMap.get(note.getId());
        if (update != null) {
            notesMap.put(note.getId(), note);
        } else {
            throw new ExceptionToFindNoteById(note.getId());
        }
    }

    public Note getById(long id) {
        Note note = notesMap.get(id);
        if (note != null) {
            return note;
        } else {
            throw new ExceptionToFindNoteById(note.getId());
        }
    }
}
