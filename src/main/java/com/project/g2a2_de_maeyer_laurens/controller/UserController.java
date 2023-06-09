package com.project.g2a2_de_maeyer_laurens.controller;

import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.User;
import com.project.g2a2_de_maeyer_laurens.repository.UserRepository;
import com.project.g2a2_de_maeyer_laurens.service.UserService;
import com.project.g2a2_de_maeyer_laurens.validator.Registration;
import com.project.g2a2_de_maeyer_laurens.validator.RegistrationValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RegistrationValidation validator;
    @Autowired
    private UserService userService;


    @PostMapping("/new")
    public String addNewUser(@Valid Registration registration, BindingResult result, Model model) {
        System.out.println("adding new user");
        validator.validate(registration, result);
        if (result.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setFirstname(registration.getFirstName());
        user.setLastname(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(registration.getPassword());

        userService.addUser(user);
        return "redirect:/login";
    }

    @PostMapping("/favorite/add/{id}")
    public String addFavorite(@PathVariable("id") Long id, Model model) {
        System.out.println("add favorite");
       Book response = userService.addFavorite(id);
        System.out.println("returning");

        System.err.println("bad request");

        User user = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()) ;
        model.addAttribute("book", response);
        model.addAttribute("user", user);
        model.addAttribute("status", "added");
        return "redirect:/books/detail/" + id+"?status=added";
    }

    @PostMapping("/favorite/remove/{id}")
    public String removeFavorite(@PathVariable("id") Long id, Model model) {
        System.out.println("remove favorite");
        Book response = userService.removeFavorite(id);
        System.out.println("returning");
//        if (!response) {
            System.err.println("bad request");
//            return ResponseEntity.badRequest().build();
//        }
        User user = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()) ;
        model.addAttribute("book", response);
        model.addAttribute("user", user);
        return "redirect:/books/detail/" + id+"?status=removed";
    }
}
