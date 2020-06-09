package com.authorsocks.soln;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SolnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolnApplication.class, args);
    }

}
