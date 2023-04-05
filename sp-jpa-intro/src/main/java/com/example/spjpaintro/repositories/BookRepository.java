package com.example.spjpaintro.repositories;

import com.example.spjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
