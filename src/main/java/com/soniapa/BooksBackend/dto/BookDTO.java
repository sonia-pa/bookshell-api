package com.soniapa.BooksBackend.dto;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BookDTO {
	
	private Integer bookId;
	
	@NotNull(message="{book.title.absent}")
	@Pattern(regexp="[A-Za-z]+( [A-Za-z])*", message="book.title.invalid")
	private String title;
	
	@NotNull(message="{book.author.absent}")
	@Pattern(regexp="[A-Za-z]+( [A-Za-z])*", message="book.author.invalid")
	private String author;
	
	@NotNull(message="{book.rating.absent}")
	@Max(value=5, message="{book.rating.invalid}")
	@Min(value=1, message="{book.rating.invalid}")
	private Integer rating;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", title=" + title + ", author=" + author + ", rating=" + rating + "]";
	}

}
