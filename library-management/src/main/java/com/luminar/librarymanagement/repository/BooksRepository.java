package com.luminar.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luminar.librarymanagement.entity.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{
	
	@Query("SELECT SUM(b.totalCopies) FROM Books b")
    int sumTotalCopies();

}
