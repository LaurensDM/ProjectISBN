package com.project.g2a2_de_maeyer_laurens.controller;

import com.project.g2a2_de_maeyer_laurens.model.User;
import com.project.g2a2_de_maeyer_laurens.repository.UserRepository;
import com.project.g2a2_de_maeyer_laurens.service.UserService;
import com.project.g2a2_de_maeyer_laurens.validator.Registration;
import com.project.g2a2_de_maeyer_laurens.validator.RegistrationValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> addFavorite(@PathVariable("id") Long id) {
        System.out.println("add favorite");
       boolean response = userService.addFavorite(id);
        System.out.println("returning");
        if (!response) {
            System.err.println("bad request");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/favorite/remove/{id}")
    public ResponseEntity<Void> removeFavorite(@PathVariable("id") Long id) {
        System.out.println("remove favorite");
        boolean response = userService.removeFavorite(id);
        System.out.println("returning");
        if (!response) {
            System.err.println("bad request");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
