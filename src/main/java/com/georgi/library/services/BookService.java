package com.georgi.library.services;

import com.georgi.library.models.Book;
import com.georgi.library.models.User;
import com.georgi.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void removeBook(Book book){
        bookRepository.delete(book);
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book findBookByTitle(String title) {
        List<Book> bookList = list();
        for(Book book : bookList) {
            if(book.getTitle().equals(title)) return book;
        }
        return null;
    }

}
