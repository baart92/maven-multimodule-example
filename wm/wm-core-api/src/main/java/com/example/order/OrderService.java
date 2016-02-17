package com.example.order;


import com.example.db.Book;
import com.example.db.Price;

import java.util.List;

public interface OrderService {
    Book addBookToOrder(Book book);

    void deleteBookFromOrder(String id);

    Price calculatePrice();

    List<Book> previewOrder();
}
