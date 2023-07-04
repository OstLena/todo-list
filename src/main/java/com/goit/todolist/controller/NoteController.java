package com.goit.todolist.controller;

import com.goit.todolist.model.Note;
import com.goit.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/note/list")
    public String noteList(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "notes";
    }

    @PostMapping("/note/add")
    public String noteAdd(Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/note/delete")
    public String noteDelete(@RequestParam Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/note/edit")
    public String noteEdit(Model model, @RequestParam Long id) {
        model.addAttribute("note", noteService.getById(id));
        return "note_edit";
    }

    @PostMapping("/note/edit")
    public String noteEdit(Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}

