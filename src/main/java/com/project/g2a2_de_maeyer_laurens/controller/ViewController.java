package com.project.g2a2_de_maeyer_laurens.controller;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping
    public String showHome() {
        return "redirect:/books";
    }

    @RequestMapping("/book/new")
    public String showForm(Model model) {
        Book book = new Book();
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            authors.add(new Author());
        }

        book.setAuthors(authors);

        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            locations.add(new Location());
        }

        book.setLocations(locations);
        model.addAttribute("book", book);
        return "newBook";
    }
    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }


//    @GetMapping("/error")
//    public String showError() {
//        return "error";
//    }
}