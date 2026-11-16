
package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    private BookRepository repository;
    private BookService service;

    @BeforeEach
    void setUp() {
        repository = new BookRepository();
        service = new BookService(repository);
    }

    // Test 1: Them sach thanh cong
    @Test
    void testAddBookSuccess() {
        Book book = new Book(1, "Java", "Author A", "123");

        boolean result = service.addBook(book);

        assertTrue(result);
        assertEquals(1, repository.findAll().size());
    }

    // Test 2: Tu choi ISBN trung lap
    @Test
    void testAddBookDuplicateIsbn() {
        Book book1 = new Book(1, "Java", "Author A", "123");
        Book book2 = new Book(2, "Python", "Author B", "123");

        service.addBook(book1);
        boolean result = service.addBook(book2);

        assertFalse(result);
        assertEquals(1, repository.findAll().size());
    }

    // Test 3: Tu choi ISBN rong
    @Test
    void testAddBookEmptyIsbn() {
        Book book = new Book(3, "C++", "Author C", "");

        boolean result = service.addBook(book);

        assertFalse(result);
        assertEquals(0, repository.findAll().size());
    }
}
