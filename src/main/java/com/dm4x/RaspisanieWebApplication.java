package com.dm4x;

/**
 * Created by kiselev on 22.02.17.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class RaspisanieWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaspisanieWebApplication.class, args);
    }
}
