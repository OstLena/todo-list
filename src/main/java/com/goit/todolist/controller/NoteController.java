package com.goit.todolist.controller;

import com.goit.todolist.model.Note;
import com.goit.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/note/list")
    public String noteList(Model model) {

        model.addAttribute("notes", noteService.listAll());

        return "notes"; //view
    }

    @PostMapping("/note/add")
    public String noteAdd(Note note) {
        noteService.add(note);
        return "redirect:/note/list";

//GET /note/list - отримати список нотаток.
// Виводиться список нотаток (title та content), кожну нотатку можна видалити або редагувати
    }


    @GetMapping("/note/delete")
    public String noteDelete(@RequestParam Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
        //POST/note/delete-видалити нотатку по ID.Після видалення нотатки відбувається редирект на/note/list
    }


}

