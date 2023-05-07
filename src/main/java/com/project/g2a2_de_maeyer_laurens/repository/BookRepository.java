package com.project.g2a2_de_maeyer_laurens.repository;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b ORDER BY b.rating DESC")
    List<Book> findByPage(Pageable pageable);

    Book findByISBNnumber(String isbn);
    List<Book> findBooksByAuthors(Author author);

    List<Book> findTop10ByOrderByRatingDescNameDesc();

    List<Book> findBookByUsers(User user);
}
