package com.luminar.librarymanagement.service;

import java.util.List;

import com.luminar.librarymanagement.entity.Books;

public interface BooksService {

	List<Books> getAllBooks();
	
	void saveBook(Books book);
	
	void deleteBookById(Integer bookId);
	
	Books getBookById(Integer id);
	
	void updateBook(Books book);
	
	int getTotalBooks();
}
