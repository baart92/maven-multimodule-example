package com.example.order;

import com.example.db.Book;
import com.example.db.BookRepository;
import com.example.db.Price;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

class OrderServiceImpl implements OrderService {
    private final BookRepository repository;
    private final BigDecimal taxPercent;

    @Autowired
    public OrderServiceImpl(BookRepository repository, BigDecimal taxPercent) {
        this.repository = repository;
        this.taxPercent = taxPercent;
    }

    @Override
    public Book addBookToOrder(Book book) {
        return repository.insert(book);
    }

    @Override
    public void deleteBookFromOrder(String id) {
        Optional<Book> book = repository.getWithId(id);
        if (book.isPresent()) {
            repository.delete(book.get());
        }
    }

    @Override
    public Price calculatePriceAfterAddingTax() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<Book> books = repository.getAll();
        repository.deleteAll();
        for (Book book : books) {
            totalPrice = totalPrice.add(book.getPrice().getValue());
        }
        return new Price(totalPrice.multiply(BigDecimal.ONE.add(taxPercent)));
    }

    @Override
    public List<Book> previewOrder() {
        return repository.getAll();
    }
}
