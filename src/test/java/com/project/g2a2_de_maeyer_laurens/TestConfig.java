package com.project.g2a2_de_maeyer_laurens;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.project.g2a2_de_maeyer_laurens.*"})
@EnableJpaRepositories(basePackages = {"com.project.g2a2_de_maeyer_laurens.*"})
public class TestConfig {
    // additional test configuration, such as beans or database setup
}
