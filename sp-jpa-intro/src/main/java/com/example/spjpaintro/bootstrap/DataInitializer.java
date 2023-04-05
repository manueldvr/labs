package com.example.spjpaintro.bootstrap;

import com.example.spjpaintro.domain.Book;
import com.example.spjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

/**
 * DataInitializaer
 *
 * Shows that connection and SQL is done by SpringData JPA and the auto configuration capabilities  of Spring Boot and
 * Hibernate. Because Hibernite initilize behind scenes doing reflection on the Book class. SQL statement creation in
 * H2 in-memory DB.
 */
@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // delete all
        bookRepository.deleteAll();
        // reinitialize all
        Book bookDDD = new Book(346765487, "RandomHouse", "Data Driven Design" );
        Book bookSIA = new Book(377765400,"OReilly", "Spring In Action");
        System.out.println("Id:"+ bookDDD.getId());
        System.out.println("Id:"+ bookSIA.getId());
        System.out.println("saving...");
        Book bookDDDsaved = this.bookRepository.save(bookDDD);
        Book bookSIAsaved = this.bookRepository.save(bookSIA);
        System.out.println("saved, Id:"+ bookDDDsaved.getId());
        System.out.println("saved, Id:"+ bookSIAsaved.getId());
        this.bookRepository.findAll().forEach(book -> {
            System.out.println("-Book found:");
            System.out.println("book id:    "+ book.getId());
            System.out.println("book Title: "+ book.getTitle());
        });
    }
}
