package com.example.spjpaintro.domain;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Book definition for a JPA context.
 */
@Entity
public class Book {

    /**
     * strategy for Id is AUTO: allow persistance provider to automatically assigns this identity, DB will manage it
     * if ORACLE sequence is fairly common.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int isbn;

    private String publisher;

    private String title;

     /** Hibernate will automatically search for a not argument constructor.   */
    public Book() {}

    public Book(int isbn, String publisher, String title) {
        this.isbn = isbn;
        this.publisher = publisher;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return id !=null ? Objects.hash(id) : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
