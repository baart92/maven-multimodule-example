package com.example.db;

import java.util.UUID;

class BookEntity implements Book {
    private String id;
    private String name;
    private Price price;

    BookEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private String id;
        private String name;
        private Price price;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPrice(Price price) {
            this.price = price;
            return this;
        }

        public BookEntity build() {
            this.id = getRandomId();
            return new BookEntity(this);
        }

        private String getRandomId() {
            return UUID.randomUUID().toString();
        }
    }
}
