package com.accenture.csd2.service;

import java.util.List;

import com.accenture.csd2.entity.Books;

public interface BooksService {
	Books saveNewBook(Books books);
	List<Books> getAllBooks();
	Books getBooksById(long id);
	List<Books> getBooksByAuthor(String author);
	List<Books> getBooksByName(String title);
	Books updateBook(Books books, long id);
	void deleteBook(long id);
}
