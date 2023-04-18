package com.project.g2a2_de_maeyer_laurens.service;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.Location;

public interface BookService {
    public Book getBookById(String id);
    public Book getBookByTitle(String title);
    public Book getBookByAuthor(Author author);
    public Book getBookByLocation(Location location);
    public Book getBookByISBN(String isbn);

    public void addBook(Book book);

    public void updateBookById(String id);

    public void deleteBookById(String id);


}
