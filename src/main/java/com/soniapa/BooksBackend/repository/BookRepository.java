package com.soniapa.BooksBackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.soniapa.BooksBackend.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	

}
