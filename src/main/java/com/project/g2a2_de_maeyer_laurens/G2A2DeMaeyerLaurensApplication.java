package com.project.g2a2_de_maeyer_laurens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class G2A2DeMaeyerLaurensApplication {

    public static void main(String[] args) {
        //Get the classpath
        String classpath = System.getProperty("java.class.path");
        System.out.println(classpath);
        SpringApplication.run(G2A2DeMaeyerLaurensApplication.class, args);
    }

}
