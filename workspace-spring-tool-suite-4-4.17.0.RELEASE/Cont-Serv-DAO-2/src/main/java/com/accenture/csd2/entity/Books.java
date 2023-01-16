package com.accenture.csd2.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
//import lombok.Data;

//@Data
@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title", nullable=false, unique=true)
	@NotEmpty(message="Title must contain something.")
	@Size(min=5, max=60, message="Title '${validatedValue}' must be between {min} and {max} characters long.")
	private String title;
	
	@Column(name="author")
	@NotEmpty(message="Author field must contain something.")
	@Size(min=5, max=40, message="Author name '${validatedValue}' must be between {min} and {max} characters long.")
	private String author;
	
	@Column(name="year_published")
	@PastOrPresent(message="Publish year must be in the past or up till the present.")
	private Date year_published;

	public Books() {
		super();
	}

	public Books(long id, @NotEmpty(message = "Title must contain something.") String title, String author,
			Date year_published) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year_published = year_published;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", year_published=" + year_published
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Date getYear_published() {
		return year_published;
	}

	public void setYear_published(Date year_published) {
		this.year_published = year_published;
	}
	
	

}
