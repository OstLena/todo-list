package com.goit.todolist.repository;

import com.goit.todolist.model.Note;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
