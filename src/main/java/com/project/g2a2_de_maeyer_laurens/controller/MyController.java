package com.project.g2a2_de_maeyer_laurens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/login")
    public String showHome() {
        return "login";
    }

    @GetMapping("/books")
    public String showBooks() {
        return "books";
    }
}
