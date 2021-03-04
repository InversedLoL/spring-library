package com.georgi.library.services;

import com.georgi.library.models.Book;
import com.georgi.library.models.User;
import com.georgi.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByName(String name) {
        List<User> userList = list();
        for(User user : userList) {
            if(user.getName().equals(name)) return user;
        }
        return null;
    }

    public List<Book> findUserBookList(User user) {
        return user.getBookList();
    }

    public void addBookToUser(User user, Book book) {
        user.addBook(book);
        userRepository.save(user);
    }

    public void removeBookFromUser(User user, Book book) {
        user.removeBook(book);
        userRepository.save(user);
    }

}
