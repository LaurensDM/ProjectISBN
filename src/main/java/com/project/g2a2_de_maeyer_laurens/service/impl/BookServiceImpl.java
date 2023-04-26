package com.project.g2a2_de_maeyer_laurens.service.impl;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.Location;
import com.project.g2a2_de_maeyer_laurens.repository.AuthorRepository;
import com.project.g2a2_de_maeyer_laurens.repository.BookRepository;
import com.project.g2a2_de_maeyer_laurens.repository.LocationRepository;
import com.project.g2a2_de_maeyer_laurens.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        System.out.println(books);
        return books;
    }


    @Override
    public Book getBookByISBN(String isbn) {
        return null;
    }

    @Override
    public void addBook(Book book) {
        List<Author> databaseAuthors = authorRepository.findAll();
        List<Location> databaseLocations = locationRepository.findAll();
        List<Author> authors = new ArrayList<>();
        List<Location> locations = new ArrayList<>();

        for (Author author : book.getAuthors()) {
            System.out.println(author.getFirstname());
            if (!author.getFirstname().isBlank() && !author.getLastname().isBlank()){
                if (databaseAuthors.contains(author)){
                    System.out.println("AUTHOR CONTAINS");
                    authors.add(databaseAuthors.get(databaseAuthors.indexOf(author)));
                } else {
                    authors.add(author);
                }
            }
        }
        for (Location location : book.getLocations()) {
            if (!location.getPlaceCode1().isBlank() && !location.getPlaceCode2().isBlank() && !location.getPlaceName().isBlank()){
                if (databaseLocations.contains(location)){
                    System.out.println("LOCATION CONTAINS");
                    locations.add(databaseLocations.get(databaseLocations.indexOf(location)));
                } else {
                    locations.add(location);
                }
            }
        }

        if (authors.isEmpty() || locations.isEmpty()){
            throw new IllegalArgumentException("Author or location is empty");
        }
        Book newBook = new Book(book.getName(), authors, book.getISBNnumber(), book.getPrice(),0, locations);
        System.out.println(newBook.toString());
        bookRepository.save(newBook);
    }


    @Override
    public void updateBookById(long id) {
        bookRepository.save(bookRepository.findById(id).get());
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }
}
