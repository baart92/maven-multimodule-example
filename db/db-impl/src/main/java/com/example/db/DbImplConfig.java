package com.example.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbImplConfig {
    @Bean
    public BookRepository bookRepository() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();

        bookRepository.insert(new BookEntity.Builder()
                        .withName("Wprowadzenie do algorytmow")
                        .withPrice(Price.of("220.00"))
                        .build()
        );

        bookRepository.insert(new BookEntity.Builder()
                        .withName("Java Podstawy")
                        .withPrice(Price.of("100.00"))
                        .build()
        );

        return bookRepository;
    }
}
