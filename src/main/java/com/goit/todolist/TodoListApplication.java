package com.goit.todolist;

import com.goit.todolist.configurations.FlywayConfigurations;
import com.goit.todolist.model.Note;
import com.goit.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TodoListApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(TodoListApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        new FlywayConfigurations()
                .setup()
                .migrate();
    }
}
