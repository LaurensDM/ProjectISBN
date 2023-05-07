package com.project.g2a2_de_maeyer_laurens.seeds;

import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.model.Location;
import com.project.g2a2_de_maeyer_laurens.model.User;
import com.project.g2a2_de_maeyer_laurens.repository.AuthorRepository;
import com.project.g2a2_de_maeyer_laurens.repository.BookRepository;
import com.project.g2a2_de_maeyer_laurens.repository.LocationRepository;
import com.project.g2a2_de_maeyer_laurens.repository.UserRepository;
import com.project.g2a2_de_maeyer_laurens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitDataConfig implements CommandLineRunner {

    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private BookRepository repo;

    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
//        Location location = new Location("A1", "B2", "Boekentoren");
//        locationRepo.save(location);
//        locationRepo.save(new Location("A1", "B2", "Boekentoren"));
        locationRepo.save(new Location(5, 300, "Boekentoren"));
        locationRepo.save(new Location(10, 290, "Boekentoren"));
        locationRepo.save(new Location(20, 280, "Boekentoren"));
        locationRepo.save(new Location(30, 270, "Boekentoren"));

//        Author author = new Author("Vittel","Deloitte");
//        authorRepo.save(author);
//        authorRepo.save(new Author("Vittel","Deloitte"));
        authorRepo.save(new Author("Laurens","De Maeyer"));
        authorRepo.save(new Author("Academie","De Boeken"));
        authorRepo.save(new Author("Jeff","De Boeken"));
        authorRepo.save(new Author("Joske","De Boeken"));


        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Vittel","Deloitte"));
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(40, 260, "Boekentoren"));
        Book book = new Book("Spring Boot for Dummies", authors, "123456789", 24.99, 5, locations, new ArrayList<>());
        repo.save(book);

        for (int i = 1; i <= 100; i++) {
            repo.save(new Book("Spring Boot for Dummies Version" + i, null, "123456789"+i, 24.99, 5, null, null));
        }

        List<Book> books = new ArrayList<>();
        books.add(new Book("Spring Boot for Dummies Ghost edition", null, "23456789", 24.99, 5, null, null));
        User user = new User("Laurens", "De Maeyer", "newPwd", "laurens@mail.com", "USER,ADMIN", books, 100);
        userService.addUser(user);
    }
}
