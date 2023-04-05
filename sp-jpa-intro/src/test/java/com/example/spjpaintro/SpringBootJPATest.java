package com.example.spjpaintro;

import com.example.spjpaintro.domain.Book;
import com.example.spjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 *  SpringBootJPATest class test the persistance layer only using @DataJpaTest annotation.
 *  In the basic example sets H2-database automatically, as well as entities  and spring data.
 *  Order is set. If sequence is important.
 *  Commit persists data between tests, like Rollback(false)
 *  ComponentScan will introduce specific list of package to the context. In case that jpa context is not enough.
 *
 * @see Commit
 * @see Order
 * @see DataJpaTest
 * @see ComponentScan
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.example.spjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJPATest {

    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void jpaSplice() {
        Long count1 = bookRepository.count();
        assertThat(count1).isEqualTo(2);
        bookRepository.save(new Book(98547 , "Self Publisher", "Test Book"));
        Long count2 = bookRepository.count();
        assertThat(count1).isLessThan(count2);
    }

    @Order(2)
    @Test
    void jpaSpliceTransaction() {
        Long count1 = bookRepository.count();
        assertThat(count1).isEqualTo(3);
        bookRepository.save(new Book(98545 , "Self Publisher", "Test Book"));
        Long count2 = bookRepository.count();
        assertThat(count1).isLessThan(count2);
    }
}
