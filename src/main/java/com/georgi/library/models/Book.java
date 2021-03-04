package com.georgi.library.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long bookId;

    private String title;

    @ManyToMany
    private List<User> readBy;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addReadBy(User user) {
        readBy.add(user);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", readBy=" + readBy +
                '}';
    }
}
