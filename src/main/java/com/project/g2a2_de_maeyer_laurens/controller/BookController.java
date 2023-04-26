package com.project.g2a2_de_maeyer_laurens.controller;

import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public String showBookById(@PathVariable Long id, Model model) {
        Book book = service.getBookById(id);
        if (book == null) {
            return "redirect:/error";
        }
        model.addAttribute("book", book);
        return "bookDetails";
    }

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("bookList", service.getAll());
        return "books";
    }

    @PostMapping("/new")
    public String onSubmit(Book book) {
        System.out.println(book.toString());
        System.out.println(book.getAuthors());
        System.out.println(book.getAuthors().get(0).getFirstname());
        System.out.println(book.getLocations().get(0).getPlaceName());
        service.addBook(book);
        return "books";
    }
}
