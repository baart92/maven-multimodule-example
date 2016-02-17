package com.example.rest;

import com.example.db.Book;
import com.example.db.Price;

class BookDTO implements Book {
    private final String name;
    private final Price price;

    public BookDTO(String name, String priceString) {
        this.name = name;
        this.price = Price.of(priceString);
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Price getPrice() {
        return price;
    }
}
