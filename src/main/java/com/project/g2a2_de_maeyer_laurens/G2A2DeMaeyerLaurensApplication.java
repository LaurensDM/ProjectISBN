package com.project.g2a2_de_maeyer_laurens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class G2A2DeMaeyerLaurensApplication {

    @Bean
    LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.forLanguageTag("en"));
        return slr;
    }

    public static void main(String[] args) {
        SpringApplication.run(G2A2DeMaeyerLaurensApplication.class, args);
    }

}
