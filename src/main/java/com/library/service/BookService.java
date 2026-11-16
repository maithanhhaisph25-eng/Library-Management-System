
package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;

public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public boolean addBook(Book book) {

        // Kiem tra sach co hop le khong
        if (book == null) {
            return false;
        }

        // Kiem tra ISBN rong
        if (book.getIsbn() == null
                || book.getIsbn().trim().isEmpty()) {
            return false;
        }

        // Kiem tra ISBN da ton tai
        if (repository.existsByIsbn(book.getIsbn())) {
            return false;
        }

        // Luu sach moi
        repository.save(book);

        return true;
    }
}
