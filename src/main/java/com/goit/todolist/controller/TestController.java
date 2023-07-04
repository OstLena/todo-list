package com.goit.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class TestController {

//    @GetMapping("/test")
//    public String test() {
//        return "ok";
//    }

    @GetMapping("/test")
    public String test(Model model) {

//        model.addAttribute("message", name);

        return "test"; //view
    }
}
