package com.soniapa.BooksBackend.service;

import java.util.List;

import com.soniapa.BooksBackend.dto.BookDTO;
import com.soniapa.BooksBackend.exception.BookException;

public interface BookService {
//	public Integer bookCourier(BookDTO bookDTO) throws BookException;
	public BookDTO getBookDetail(Integer bookId) throws BookException;
	public List<BookDTO> getAllBooks() throws BookException; 
	public void addBook(BookDTO bookDTO) throws BookException;
	public void updateBook(Integer bookId, String bookName) throws BookException;
	public void deleteBook(Integer bookId) throws BookException;


}
