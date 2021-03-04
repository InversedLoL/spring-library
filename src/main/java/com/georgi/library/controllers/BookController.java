package com.georgi.library.controllers;

import com.georgi.library.models.Book;
import com.georgi.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("book/all")
    @ResponseBody
    public List<Book> allBooks() {
        return bookService.list();
    }

    @GetMapping("book/findById")
    @ResponseBody
    public Book findBookById(@RequestParam Long id) {
        return bookService.findBookById(id);
    }

    @GetMapping("book/findByTitle")
    @ResponseBody
    public Book findBookByTitle(@RequestParam String title) {
        return bookService.findBookByTitle(title);
    }

    @PostMapping("book/add")
    public void addBook(@RequestParam String title) {
        bookService.addBook(new Book(title));
    }

    @DeleteMapping("book/removeById")
    public void deleteBookById(@RequestParam Long id) {
        bookService.removeBook(bookService.findBookById(id));
    }

    @DeleteMapping("book/removeByTitle")
    public void deleteBookByTitle(@RequestParam String title) {
        bookService.removeBook(bookService.findBookByTitle(title));
    }

}
