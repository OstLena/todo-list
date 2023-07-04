package com.goit.todolist.exception;

public class ExceptionToFindNoteById extends RuntimeException{

    public ExceptionToFindNoteById(Long noteId) {
        super("Error to find note by ID " + noteId);
    }
}
