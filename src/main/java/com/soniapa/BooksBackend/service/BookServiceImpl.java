package com.soniapa.BooksBackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soniapa.BooksBackend.dto.BookDTO;
import com.soniapa.BooksBackend.entity.Book;
import com.soniapa.BooksBackend.exception.BookException;
import com.soniapa.BooksBackend.repository.BookRepository;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public BookDTO getBookDetail(Integer bookId) throws BookException {
		Optional<Book> optional = bookRepository.findById(bookId);
		Book book = optional.orElseThrow(() -> new BookException("Service.NO_RECORDS_FOUND"));
		BookDTO bookDTO = new BookDTO();
		bookDTO.setBookId(book.getBookId());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setRating(book.getRating());
		return bookDTO;
	}

	@Override
	public void addBook(BookDTO bookDTO) throws BookException {
		Book book = new Book();
		book.setBookId(bookDTO.getBookId());
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setRating(bookDTO.getRating());
		bookRepository.save(book);
		
	}

	
	@Override
	public void deleteBook(Integer bookId) throws BookException {
		Optional<Book> optional = bookRepository.findById(bookId);
		optional.orElseThrow(() -> new BookException("General.EXCEPTION_MESSAGE"));
		bookRepository.deleteById(bookId);;

	}

	@Override
	public List<BookDTO> getAllBooks() throws BookException {
		Iterable<Book> books = bookRepository.findAll();
		List<BookDTO> allBooks = new ArrayList<>();
		books.forEach(book -> {
			BookDTO temp = new BookDTO();
			temp.setBookId(book.getBookId());
			temp.setTitle(book.getTitle());
			temp.setAuthor(book.getAuthor());
			temp.setRating(book.getRating());
			allBooks.add(temp);
		});
		return allBooks;
	}

	@Override
	public void updateBook(Integer bookId, String bookName) throws BookException {
		Optional<Book> optional = bookRepository.findById(bookId);
		Book book = optional.orElseThrow(() -> new BookException("Service.NO_RECORDS_FOUND"));
		book.setTitle(bookName);
		
	}

}
