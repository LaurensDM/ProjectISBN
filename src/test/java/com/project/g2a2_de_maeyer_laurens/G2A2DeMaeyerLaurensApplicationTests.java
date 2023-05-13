package com.project.g2a2_de_maeyer_laurens;

import com.project.g2a2_de_maeyer_laurens.controller.ViewController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class G2A2DeMaeyerLaurensApplicationTests {

    @Autowired
    private ViewController viewController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertThat(viewController).isNotNull();
    }

    @Test
    public void loginGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    public void registerGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    public void homeGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("books"));
    }

    @Test
    public void accessDeniedGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books/detail/1"))
                .andExpect(status().is3xxRedirection());
    }

}
