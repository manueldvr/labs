package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Newauthoruuid;
import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.AuthorUUIDRepository;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/12/21.
 */
@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    private final AuthorUUIDRepository authorUUIDReporitory;


    public DataInitializer(BookRepository bookRepository, AuthorUUIDRepository authorUUIDReporitory) {
        this.bookRepository = bookRepository;
        this.authorUUIDReporitory = authorUUIDReporitory;
    }


    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        authorUUIDReporitory.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely", null);
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

        Newauthoruuid authorUUID = new Newauthoruuid();
        authorUUID.setFirstName("Joe");
        authorUUID.setLastName("Apple");
        Newauthoruuid savedNewauthoruuid = authorUUIDReporitory.save(authorUUID);
    }
}
