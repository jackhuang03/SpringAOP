package com.jack.exercise.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import com.jack.exercise.dto.Book;

@SpringBootTest
public class BookControllerTest {

	private RestTemplate rest;
	
	@BeforeEach
	public void setup() {
		rest = new RestTemplate();
	}
	
	@Test
	public void testListBookById() throws Exception {
		Integer expected = 1;
		Integer actual;

		actual = rest.getForObject("http://localhost:8083/books/{isbn}", Book.class, 1).getIsbn();
		assertEquals(expected, actual);
	}

	@Test
	public void testListBooks() throws Exception {
		Integer expected = 3;
		Integer actual;

		RequestEntity<Void> request = RequestEntity.get(URI.create("http://localhost:8083/books/")).accept(MediaType.APPLICATION_JSON).build();
		actual = rest.exchange(request, new ParameterizedTypeReference<List<Book>>(){}).getBody().size();
		assertEquals(expected, actual);
	}
}