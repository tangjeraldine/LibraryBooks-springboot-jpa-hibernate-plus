package com.accenture.csd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.csd2.entity.Books;
import com.accenture.csd2.service.BooksService;
import com.accenture.csd2.service.BooksServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BooksController {
	
	@Autowired
	private BooksServiceImp booksServ;
	
	@PostMapping("/newbook")
	public ResponseEntity<Books> saveNewBook(@Valid @RequestBody Books books){
		return new ResponseEntity<Books>(booksServ.saveNewBook(books), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public List<Books>getAllBooks(){
		return booksServ.getAllBooks();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Books> getBooksById(@PathVariable("id") long id){
		return new ResponseEntity<Books> (booksServ.getBooksById(id), HttpStatus.OK);
	}
	
	@GetMapping("/author/{author}")
	public List<Books> getBooksByAuthor(@PathVariable("author") String author){
		return booksServ.getBooksByAuthor(author);
	}
	
	@GetMapping("/title/{title}")
	public List<Books> getBooksByName(@PathVariable String title){
		return booksServ.getBooksByName(title);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Books>  updateBook(@PathVariable("id") long id, @RequestBody Books books){
		return new ResponseEntity<Books> (booksServ.updateBook(books, id), HttpStatus.OK)
;	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id){
		booksServ.deleteBook(id);
		return new ResponseEntity<String> ("Book deleted successfully.", HttpStatus.OK);
	}

}
