package com.jack.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.exercise.dao.BookDao;
import com.jack.exercise.dto.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao dao;
	
	public Book listBookByIsbn(Integer isbn) {
		return dao.queryBookByIsbn(isbn);
	}
	
	public List<Book> listBooks() {
		return dao.queryBooks();
	}
	
}
