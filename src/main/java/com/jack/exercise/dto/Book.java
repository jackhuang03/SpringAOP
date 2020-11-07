package com.jack.exercise.dto;

public class Book {
	private Integer isbn;
	
	private String author;
	
	private String name;
	
	public Book() {
		super();
	}
	
	public Book(Integer isbn, String author, String name) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.name = name;
	}
	
	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", name=" + name + "]";
	}
	
}
