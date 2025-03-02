package com.luminar.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luminar.librarymanagement.entity.Books;
import com.luminar.librarymanagement.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {
	@Autowired
	private BooksRepository booksRepository;

	@Override
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }
	
	@Override
    public void saveBook(Books book) {
        booksRepository.save(book);
    }
	
	@Override
	public void deleteBookById(Integer bookId) {
		booksRepository.deleteById(bookId);
	}
	
	@Override
	public Books getBookById(Integer id) {
        return booksRepository.findById(id).orElse(null);
    }

	@Override
    public void updateBook(Books book) {
        book.setBookTitle(book.getBookTitle().toUpperCase());
        book.setAuthor(book.getAuthor().toUpperCase());
        book.setCategory(book.getCategory().toUpperCase());
        book.setLanguage(book.getLanguage().toUpperCase());
        book.setPublication(book.getPublication().toUpperCase());
        booksRepository.save(book);
       
    }

	@Override
	public int getTotalBooks() {
		return booksRepository.sumTotalCopies();
	}


}
