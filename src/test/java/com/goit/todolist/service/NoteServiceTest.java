package com.goit.todolist.service;

import com.goit.todolist.model.Note;
import com.goit.todolist.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class NoteServiceTest {

    @Autowired
    private NoteService noteService;
    @MockBean
    private NoteRepository noteRepository;

    @Test
    void add() {
        Note note = new Note();
        note.setTitle("Test Note");
        note.setContent("Test Note Content");
        when(noteRepository.save(note))
                .thenReturn(note);
        Note noteAdded = noteService.add(note);


        assertNotNull(noteAdded);
        assertEquals(note, noteAdded);
    }

}
