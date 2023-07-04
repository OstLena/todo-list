package com.goit.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }
}
