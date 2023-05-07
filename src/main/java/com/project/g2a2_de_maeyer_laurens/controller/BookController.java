package com.project.g2a2_de_maeyer_laurens.controller;

import com.mysql.cj.protocol.AuthenticationProvider;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.User;
import com.project.g2a2_de_maeyer_laurens.service.BookService;
import com.project.g2a2_de_maeyer_laurens.service.UserService;
import com.project.g2a2_de_maeyer_laurens.validator.BookValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookValidator validator;
    @Autowired
    private BookService service;
    List<Book> books = new ArrayList<>();

    @GetMapping("/{page}")
    public String showBooksByPage(@PathVariable Integer page, Model model) {
        if (page < 1) {
            return "redirect:/books/1";
        }
        int count = service.getCount();
        if (count - (page-1)*10 < 0) {
            System.out.println(count);
            System.out.println(page*10);
            return "redirect:/books/" + (page - 1);

        }
        books = service.getBooksByPage(page);
        if (books == null || books.isEmpty()) {
            return "redirect:/error";
        }
        model.addAttribute("page", page);
        model.addAttribute("bookList", books);
        return "books";
    }

    @GetMapping("/detail/{id}")
    public String showBookById(@PathVariable Long id, Model model) {
        User user = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Book book = service.getBookById(id);
        if (book == null) {
            return "redirect:/error";
        }
        model.addAttribute("book", book);
        model.addAttribute("user", user);
        return "bookDetails";
    }

    @GetMapping
    public String getBooks(Model model) {
//        model.addAttribute("bookList", service.getAll());
        return "redirect:/books/1";
    }

    @PostMapping("/new")
    public String onSubmit(@Valid Book book, BindingResult result, Model model) {
        validator.validate(book, result);
        if (result.hasErrors()) {
            return "newBook";
        }
        System.out.println(book);
        System.out.println(book.getAuthors());
        System.out.println(book.getAuthors().get(0).getFirstname());
        System.out.println(book.getLocations().get(0).getPlaceName());
        service.addBook(book);
        return "redirect:/books/1";
    }

    @GetMapping("/top10")
    public String getTop10(Model model) {
        List<Book> books = service.getTop10();
        model.addAttribute("books", books);
        return "topTenBooks";
    }

    @GetMapping("/favorite")
    public String getFavorites(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUserByEmail(authentication.getName());
        System.out.println(currentUser);
        List<Book> books = service.getFavorites(currentUser);
        System.out.println(books);
        System.out.println(currentUser.getBooks());
        model.addAttribute("books", books);
        model.addAttribute("user", currentUser);
        return "favorites";
    }
}
