package com.example.db;

import java.util.*;

class BookRepositoryImpl implements BookRepository {
    private Map<String, Book> data = new HashMap<>();

    @Override
    public Book insert(Book book) {
        BookEntity bookEntity = new BookEntity.Builder()
                .withName(book.getName())
                .withPrice(book.getPrice())
                .build();
        data.put(bookEntity.getId(), bookEntity);
        return bookEntity;
    }

    @Override
    public void delete(Book book) {
        data.remove(book.getId());
    }

    @Override
    public Optional<Book> getWithId(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Book> getAll() {
        //TODO should be ImmutableList
        return new ArrayList<>(data.values());
    }

    @Override
    public void deleteAll() {
        data.clear();
    }
}
