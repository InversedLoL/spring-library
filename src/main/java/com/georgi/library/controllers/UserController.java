package com.georgi.library.controllers;

import com.georgi.library.models.Book;
import com.georgi.library.models.User;
import com.georgi.library.services.BookService;
import com.georgi.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("user/all")
    @ResponseBody
    public List<User> allUsers() {
        return userService.list();
    }

    @GetMapping("user/findById")
    @ResponseBody
    public User findUserById(@RequestParam Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("user/findByName")
    @ResponseBody
    public User findUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    @PostMapping("user/add")
    public void addUser(@RequestParam String name) {
        userService.addUser(new User(name));
    }

    @DeleteMapping("user/removeById")
    public void deleteUserById(@RequestParam Long id) {
        userService.removeUser(userService.findUserById(id));
    }

    @DeleteMapping("user/removeByName")
    public void deleteUserByName(@RequestParam String name) {
        userService.removeUser(userService.findUserByName(name));
    }

    @GetMapping("user/bookListById")
    @ResponseBody
    public List<Book> findUserBookListById(@RequestParam Long id) {
        return userService.findUserById(id).getBookList();
    }

    @GetMapping("user/bookListByName")
    @ResponseBody
    public List<Book> findUserBookListByName(@RequestParam String name) {
        return userService.findUserByName(name).getBookList();
    }

    @PostMapping("user/book/addById")
    public void addBookToUserById(@RequestParam(name = "user_id") Long userId, @RequestParam(name = "book_id") Long bookId) {
        userService.findUserById(userId).addBook(bookService.findBookById(bookId));
    }

    @PostMapping("user/book/addByName")
    public void addBookToUserByName(@RequestParam String name, @RequestParam String title) {
        userService.findUserByName(name).addBook(bookService.findBookByTitle(title));
    }

    @PostMapping("user/book/remove")
    public void removeBookFromUser(@RequestParam(name = "user_id", defaultValue = "") Long userId, @RequestParam(name = "book_id") Long bookId) {
        userService.findUserById(userId).removeBook(bookService.findBookById(bookId));
    }

}
