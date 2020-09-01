package com.soniapa.BooksBackend.dto;

public class BookDTO {
	private Integer bookId;
	private String title;
	private String author;
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
