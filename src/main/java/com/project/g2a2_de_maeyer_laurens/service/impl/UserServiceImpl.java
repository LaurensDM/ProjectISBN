package com.project.g2a2_de_maeyer_laurens.service.impl;

import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.User;
import com.project.g2a2_de_maeyer_laurens.repository.BookRepository;
import com.project.g2a2_de_maeyer_laurens.repository.UserRepository;
import com.project.g2a2_de_maeyer_laurens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public String getRole(Long id) {
        return null;
    }

    @Override
    public String addUser(User user) {
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return "user added to system ";
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Book addFavorite(Long id) {
        Book book = bookRepository.findById(id).get();
        User user = repository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user.getBooks().contains(book)) {
            return null;
        }
        user.addBook(book);
        repository.save(user);
        book.setStarRating(book.getRating() + 1);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book removeFavorite(Long id) {
        Book book = bookRepository.findById(id).get();
        User user = repository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (!user.getBooks().contains(book)) {
            return null;
        }
        user.removeBook(book);
        repository.save(user);
        book.setStarRating(book.getRating() - 1);
        bookRepository.save(book);
        return book;
    }
}
