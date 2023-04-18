package com.project.g2a2_de_maeyer_laurens.repository;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
    Book findByTitle(String title);
    Book findByAuthor(Author author);
    Book findByLocation(Location location);
    Book findByISBN(String isbn);
}
