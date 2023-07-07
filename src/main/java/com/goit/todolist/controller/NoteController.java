package com.goit.todolist.controller;

import com.goit.todolist.model.Note;
import com.goit.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/note")
@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public String noteList(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "notes";
    }

    @PostMapping("/add")
    public String noteAdd(Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/delete")
    public String noteDelete(@RequestParam Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String noteEdit(Model model, @RequestParam Long id) {
        model.addAttribute("note", noteService.getById(id));
        return "note_edit";
    }

    @PostMapping("/edit")
    public String noteEdit(Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}

