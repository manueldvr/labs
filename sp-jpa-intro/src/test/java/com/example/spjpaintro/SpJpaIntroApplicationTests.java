package com.example.spjpaintro;

import com.example.spjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpJpaIntroApplicationTests {

	@Autowired
	private BookRepository bookRepository;


	@Test
	void elementsEffectivelyCreated() {
		long count = bookRepository.count();
		assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
