package com.accenture.csd2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.accenture.csd2.entity.Books;
import com.accenture.csd2.exception.ResourceNotFoundException;
import com.accenture.csd2.repository.BooksRepo;

@Service
@Component
public class BooksServiceImp implements BooksService{
	
	@Autowired
	private BooksRepo booksRepo;

	@Override
	public Books saveNewBook(Books books) {
		return booksRepo.save(books);
	}

	@Override
	public List<Books> getAllBooks() {
		return booksRepo.findAll();
	}

	@Override
	public Books getBooksById(long id) {
		return booksRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Title", "ID", id));
	}
	
	@Override
	public List<Books> getBooksByAuthor(String author) {
		try {
			return booksRepo.getBooksByAuthor(author);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	// using named parameters
//	@Override
//	@Query(value="select * from books b where b.title= :title", nativeQuery=true)
//	public List<Books> getBooksByName(@Param("title") String title) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	// using positional parameters
	@Override
	public List<Books> getBooksByName(String title) {
		try {
			return booksRepo.getBooksByName(title);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public Books updateBook(Books books, long id) {
		Books existingBook = booksRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Book", "ID", id));
		existingBook.setId(books.getId());
		existingBook.setAuthor(books.getAuthor());
		existingBook.setTitle(books.getTitle());
		existingBook.setYear_published(books.getYear_published());
		return booksRepo.save(existingBook);			
	}

	@Override
	public void deleteBook(long id) {
		booksRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Book", "ID", id));
		booksRepo.deleteById(id);
	}


	

}
