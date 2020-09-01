package com.soniapa.BooksBackend.exception;

public class BookException extends Exception {
	private static final long serialVersionUID = 1L;
	public BookException() {
		super();
	}
	
	public BookException(String message) {
		super(message);
	}

}
