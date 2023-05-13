package com.project.g2a2_de_maeyer_laurens;


import com.project.g2a2_de_maeyer_laurens.controller.BookController;
import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private MockMvc mockMvc;

//    @BeforeEach
//    public void before() {
//        MockitoAnnotations.openMocks(this);
//        bookController = new BookController();
//        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//        System.out.println(mockMvc.toString());
//        ReflectionTestUtils.setField(bookController, "service", bookService);
//    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(bookController).isNotNull();
    }

    @Test
    public void testShowBooks() throws Exception {
        Book book = new Book( "test", null, "123456789102",15,0,null,null);
        book.setId((long) 1);
        List<Book> books = new ArrayList<>();
        books.add(book);

        BookService bookService = Mockito.mock(BookService.class);
//        Mockito.when(bookService.getBooksByPage(1)).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("books"));
//                .andExpect(model().attribute("bookList", book));
//        Mockito.verify(bookService, Mockito.times(1)).getBooksByPage(1);


    }

    @WithMockUser(username = "random", authorities = {"USER"})
    @Test
    public void testShowBookById() throws Exception {
//        Book book = new Book( "test", null, "123456789102",15,0,null,null);
//        book.setId((long) 1);


//        BookService bookService = Mockito.mock(BookService.class);
//        Mockito.when(bookService.getBookById(1)).thenReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/detail/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookDetails"))
                .andExpect(model().attributeExists("book"));
//                .andExpect(model().attribute("book", book));
    }


}
