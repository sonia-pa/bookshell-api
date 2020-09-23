package com.soniapa.BooksBackend;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.soniapa.BooksBackend.dto.BookDTO;
import com.soniapa.BooksBackend.entity.Book;
import com.soniapa.BooksBackend.exception.BookException;
import com.soniapa.BooksBackend.repository.BookRepository;
import com.soniapa.BooksBackend.service.BookService;
import com.soniapa.BooksBackend.service.BookServiceImpl;

@SpringBootTest
class BooksBackendApplicationTests {
	
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService = new BookServiceImpl();

	@Test
	public void GetBoooktIdTest() throws Exception{
		Book book = new Book();
		book.setAuthor("testAuthorName");
		book.setTitle("testTitle");
		book.setBookId(1);
		book.setRating(2);
		
		BookDTO expected = new BookDTO();
		expected.setBookId(book.getBookId());
		expected.setAuthor(book.getAuthor());
		expected.setRating(book.getRating());
		expected.setTitle(book.getTitle());
		
		Optional<Book> optional = Optional.of(book);
		
		Mockito.when(bookRepository.findById(1)).thenReturn(optional);
		BookDTO bookDTO = bookService.getBookDetail(optional.get().getBookId());
		Assertions.assertEquals(expected,bookDTO);
		
	}
	

}
