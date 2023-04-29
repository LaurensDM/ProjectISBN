package com.project.g2a2_de_maeyer_laurens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@EnableJpaRepositories("com.project.g2a2_de_maeyer_laurens.*")
@ComponentScan("com.project.g2a2_de_maeyer_laurens.*")
@EntityScan("com.project.g2a2_de_maeyer_laurens.*")
public class G2A2DeMaeyerLaurensApplication  {

    public static void main(String[] args) {
        SpringApplication.run(G2A2DeMaeyerLaurensApplication.class, args);
    }

}
