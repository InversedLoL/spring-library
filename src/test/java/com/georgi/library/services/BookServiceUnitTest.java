package com.georgi.library.services;

import com.georgi.library.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class BookServiceUnitTest {

    @Autowired
    private BookService bookService;

    @Test
    public void intitialRecordsCreated() {
        List<Book> books = bookService.list();

        Assertions.assertEquals(3, books.size());
    }

}
