package com.project.g2a2_de_maeyer_laurens.service;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    public Book getBookById(long id);
    public List<Book> getAll();
//    public Book getBookByTitle(String title);
//    public Book getBookByAuthor(Author author);
//    public Book getBookByLocation(Location location);
    public Book getBookByISBN(String isbn);

    public void addBook(Book book);

    public void updateBookById(long id);

    public void deleteBookById(long id);


}
