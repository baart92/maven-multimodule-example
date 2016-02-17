package com.example.order;

import com.example.db.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.math.BigDecimal;

@Configuration
@PropertySource("classpath:tax.properties")
public class CoreImplConfig {
    @Value("${tax.percent}")
    private double taxPercent;

    @Autowired
    private BookRepository repository;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public OrderService orderService() {
        OrderServiceImpl orderService = new OrderServiceImpl(repository, new BigDecimal(taxPercent));
        return orderService;
    }
}
