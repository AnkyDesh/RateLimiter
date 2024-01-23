package com.javainuse.controllers;

public class BookNotFoundException extends RuntimeException {
	
	public BookNotFoundException(String message) {
		super(message);
	}

}
