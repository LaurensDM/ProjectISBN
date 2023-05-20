package com.project.g2a2_de_maeyer_laurens;

import com.project.g2a2_de_maeyer_laurens.model.Book;
import com.project.g2a2_de_maeyer_laurens.service.RestService;
import com.project.g2a2_de_maeyer_laurens.validator.BookValidator;
import com.project.g2a2_de_maeyer_laurens.validator.RegistrationValidation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.project.g2a2_de_maeyer_laurens.*")
@ComponentScan("com.project.g2a2_de_maeyer_laurens.*")
@EntityScan("com.project.g2a2_de_maeyer_laurens.*")
public class G2A3DeMaeyerLaurensApplication {

    @Bean
    public RegistrationValidation registrationValidation() {
        return new RegistrationValidation();
    }

    @Bean
    public BookValidator bookValidator() {
        return new BookValidator();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(G2A3DeMaeyerLaurensApplication.class, args);
        RestService restService = context.getBean(RestService.class);
        System.out.println(restService.getBookByIsbn("123456789").toString());
        for (Book book : restService.getBooksByAuthor(5).getBody()) {
            System.out.println(book.toString());
        }
    }

}
