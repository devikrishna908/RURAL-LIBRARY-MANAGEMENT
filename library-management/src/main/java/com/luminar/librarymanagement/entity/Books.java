package com.luminar.librarymanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "author")
    private String author;

    @Column(name = "category")
    private String category;
    
    @Column(name = "language")
    private String language;
    
    @Column(name = "publication")
    private String publication;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "total_copies")
    private int totalCopies;
    

	public Books() {
	}

	public Books(Integer book_id, String bookTitle, String author, String category, String language, String publication,
			double price, int totalCopies) {
		this.book_id = book_id;
		this.bookTitle = bookTitle;
		this.author = author;
		this.category = category;
		this.language = language;
		this.publication = publication;
		this.price = price;
		this.totalCopies = totalCopies;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle.toUpperCase();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author.toUpperCase();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category.toUpperCase();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language.toUpperCase();
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication.toUpperCase();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	
}
