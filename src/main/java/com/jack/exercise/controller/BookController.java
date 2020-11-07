package com.jack.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jack.exercise.dto.Book;
import com.jack.exercise.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public List<Book> listBooks() {
		return service.listBooks();
	}
	
	@GetMapping("/{isbn}")
	public Book listBookById(@PathVariable("isbn") Integer isbn ) {
		return service.listBookByIsbn(isbn);
	}
	
}
