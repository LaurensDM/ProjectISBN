package com.project.g2a2_de_maeyer_laurens;

import com.project.g2a2_de_maeyer_laurens.controller.RestController;
import com.project.g2a2_de_maeyer_laurens.controller.ViewController;
import com.project.g2a2_de_maeyer_laurens.model.Author;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.repository.AuthorRepository;
import com.project.g2a2_de_maeyer_laurens.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class RestControllerTest {

    @Mock
    private BookService mock;

    @Mock
    private AuthorRepository authorRepository;

    private RestController restController;


    private MockMvc mockMvc;

    private void performRest(String uri) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(status().isOk());
    }

    @Test
    public void test_GetBookByIsbn() throws Exception {
        MockitoAnnotations.openMocks(this);
        restController = new RestController();
        mockMvc = standaloneSetup(restController).build();
        ReflectionTestUtils.setField(restController, "service", mock);

        Book book = new Book("Spring Boot for Dummies Version1", null, "1234567891", 24.99, 5, null, null);
        book.setId((long) 10);

        Mockito.when(mock.getByISBN("1234567891")).thenReturn(book);

        performRest("/api/books/1234567891");

        Mockito.verify(mock).getByISBN("1234567891");


//        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/123467891"))
//                .andExpect(status().isOk());


    }

    @Test
    public void test_GetBooksByAuthors() throws Exception {
        MockitoAnnotations.openMocks(this);
        restController = new RestController();
        mockMvc = standaloneSetup(restController).build();
        ReflectionTestUtils.setField(restController, "service", mock);
        ReflectionTestUtils.setField(restController, "authorRepository", authorRepository);

        Author author = new Author("Laurens", "De Maeyer");
        author.setId((long) 5);
        //create a list of authors
        ArrayList<Author> authorList = new ArrayList<>();
        authorList.add(author);

        Book book = new Book("Spring Boot for Dummies Version1", authorList, "1234567891", 24.99, 5, null, null);
        book.setId((long) 10);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        Mockito.when(authorRepository.findById((long) 5)).thenReturn(java.util.Optional.of(author));

        Mockito.when(mock.getByAuthor(author)).thenReturn(bookList);

        performRest("/api/authors/5");

        Mockito.verify(authorRepository).findById((long) 5);

        Mockito.verify(mock).getByAuthor(author);
    }

}
