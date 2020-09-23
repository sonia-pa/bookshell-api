package com.soniapa.BooksBackend.api;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import com.soniapa.BooksBackend.dto.BookDTO;
import com.soniapa.BooksBackend.exception.BookException;
import com.soniapa.BooksBackend.service.BookService;

@RestController
@CrossOrigin
@RequestMapping("/books")
@Validated
public class BookshellAPI {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private Environment environment;

	@GetMapping(value = "/")
	public ResponseEntity<List<BookDTO>> getAllBooks() throws BookException{
		List<BookDTO> bookList = bookService.getAllBooks();
		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{bookId}")
	public ResponseEntity<BookDTO> getBook(@PathVariable Integer bookId) throws BookException {
		BookDTO book = bookService.getBookDetail(bookId);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping(value="/")
	public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) throws BookException {
		bookService.addBook(bookDTO);
		String successMessage = environment.getProperty("API.BOOK_SUCCESS");
		return new ResponseEntity<>(bookDTO, HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable Integer bookId, @RequestBody BookDTO bookDTO) throws BookException {
		bookService.updateBook(bookId, bookDTO.getTitle());
		String successMessage = environment.getProperty("API.STATUS_CHANGE");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) throws BookException {
		bookService.deleteBook(bookId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}

}
