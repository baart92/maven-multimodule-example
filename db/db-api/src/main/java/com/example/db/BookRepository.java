package com.example.db;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book insert(Book book);

    void delete(Book book);

    Optional<Book> getWithId(String id);

    List<Book> getAll();

    void deleteAll();


}
