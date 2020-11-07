package com.jack.exercise.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jack.exercise.dto.Book;

@Repository
public class BookDao {
	
	public Book queryBookByIsbn(Integer isbn) {
		return getBookRepository().stream().filter(e -> e.getIsbn().equals(isbn)).findFirst().get();
	}
	
	public List<Book> queryBooks() {
		return getBookRepository();
	}
	
	private List<Book> getBookRepository() {
		return Arrays.asList(
				new Book(1, "Jack Huang", "Book the wonderland"),
				new Book(2, "Jean Tseng", "Book the hell land"),
				new Book(3, "Norah Gin", "Book the moon night")
			  );
	}
	
}
