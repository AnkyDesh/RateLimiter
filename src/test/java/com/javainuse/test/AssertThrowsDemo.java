package com.javainuse.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import com.javainuse.controllers.BookNotFoundException;
import com.javainuse.controllers.BookService;
import com.javainuse.model.Book;

public class AssertThrowsDemo {

	@Test
	public void assertThrowsWithNoMessage() {
		BookService bookService = new BookService();

		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");

		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);

		BookNotFoundException bookNotFoundException = assertThrows(BookNotFoundException.class,
				() -> bookService.getBookByTitle("Head First Spring"));

		assertEquals("Book not found in Bookstore!", bookNotFoundException.getMessage());
	}
	@Disabled
	@Test
	public void assertThrowsWithMessage() {
		BookService bookService = new BookService();

		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");

		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);

		assertThrows(BookNotFoundException.class,
				() -> bookService.getBookByTitle("Head First Spring"),
				"Different exception thrown!");

	}
    @Disabled
	@Test
	public void assertThrowsWithMessageSupplier() {
		BookService bookService = new BookService();

		Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
		Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Packt");

		bookService.addBook(headFirstJavaBook);
		bookService.addBook(headFirstDesignPatternBook);

		assertThrows(BookNotFoundException.class,
				() -> bookService.getBookByTitle("Head First Spring"),
				() -> "Different exception thrown!");

	}

}