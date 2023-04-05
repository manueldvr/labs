package com.example.spjpaintro;

import com.example.spjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.example.spjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testMySQL() {
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
}
