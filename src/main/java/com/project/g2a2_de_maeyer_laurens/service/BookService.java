package com.project.g2a2_de_maeyer_laurens.service;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.Location;
import com.project.g2a2_de_maeyer_laurens.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    int getCount();
    Book getBookById(long id);
    List<Book> getBooksByPage(Integer page);
    List<Book> getAll();

    List<Book> getByAuthor(Author author);

    Book getByISBN(String isbn);

    void addBook(Book book);

    void updateBookById(long id);

    void deleteBookById(long id);

    List<Book> getTop10();

    List<Book> getFavorites(User user);
}
