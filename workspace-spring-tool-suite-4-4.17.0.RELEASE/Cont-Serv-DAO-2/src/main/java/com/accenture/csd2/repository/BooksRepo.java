package com.accenture.csd2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.accenture.csd2.entity.Books;

@Component
public interface BooksRepo extends JpaRepository<Books, Long>{

	@Query("from Books b where b.title like %?1% order by title ASC")
	List<Books> getBooksByName( String title);
	
	@Query("from Books b where b.author like %?1% order by title ASC")
	List<Books> getBooksByAuthor(String author);
}