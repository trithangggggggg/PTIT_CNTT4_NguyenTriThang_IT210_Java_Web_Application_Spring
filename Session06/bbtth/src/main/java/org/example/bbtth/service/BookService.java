package org.example.bbtth.service;

import org.example.bbtth.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final List<Book> books = List.of(
            new Book(1L, "Dragon Ball Super", "Nguyễn Trí Thắng", 350000.0),
            new Book(2L, "Doraemon", "Nguyễn Tuấn Minh", 180000.0),
            new Book(3L, "One Piece", "Vũ Việt Tiến", 420000.0),
            new Book(4L, "Naruto", "Phạm Quốc Lộc", 250000.0)
    );

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}