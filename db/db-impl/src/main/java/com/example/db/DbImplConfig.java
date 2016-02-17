package com.example.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbImplConfig {
    @Bean
    public BookRepository bookRepository() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();

        bookRepository.insert(new BookEntity.Builder()
                        .withName("Wprowadzenie do algorytm�w")
                        .withPrice(Price.of("120.50"))
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
