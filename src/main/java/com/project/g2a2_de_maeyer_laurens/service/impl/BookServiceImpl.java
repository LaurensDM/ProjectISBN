package com.project.g2a2_de_maeyer_laurens.service.impl;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.Location;
import com.project.g2a2_de_maeyer_laurens.repository.BookRepository;
import com.project.g2a2_de_maeyer_laurens.service.BookService;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book getBookByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public Book getBookByLocation(Location location) {
        return bookRepository.findByLocation(location);
    }

    @Override
    public Book getBookByISBN(String isbn) {
        return null;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBookById(String id) {
        bookRepository.save(bookRepository.findById(id).get());
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }
}
