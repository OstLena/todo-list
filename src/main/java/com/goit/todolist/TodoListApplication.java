package com.goit.todolist;

import com.goit.todolist.model.Note;
import com.goit.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApplication implements CommandLineRunner {

    @Autowired
    private NoteService noteService;


    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Note noteA = Note.builder()
                .title("Note A")
                .content("First note")
                .build();

        noteService.add(noteA);

        Note noteB = Note.builder()
                .title("Note B")
                .content("Second note")
                .build();

        noteService.add(noteB);

        noteService.listAll().forEach(System.out::println);
        System.out.println();

        Note noteBUpdated = Note.builder()
                .id(noteB.getId())
                .title("Note B Updated")
                .content("Second note")
                .build();
        noteService.update(noteBUpdated);

        Note byId = noteService.getById(noteB.getId());
        System.out.println(byId);
        System.out.println();

        noteService.deleteById(byId.getId());
        noteService.listAll().forEach(System.out::println);

    }
}
