package com.luminar.librarymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luminar.librarymanagement.entity.IssueDetails;

public interface IssueDetailsRepository extends JpaRepository<IssueDetails, Integer>{
	
	@Query("SELECT COUNT(issue_id) FROM IssueDetails WHERE bookId = :bookId AND returnDate IS NULL")
    Integer countIssuedBooksByBookId(@Param("bookId")Integer bookId);

	@Query("SELECT COUNT(issue_id) FROM IssueDetails WHERE mem_regno = :memberId AND returnDate IS NULL")
    Integer countIssuedBooksToMember(@Param("memberId") Integer memberId);
	
	@Query("SELECT id.issue_id, b.bookTitle, id.issueDate, id.dueDate " +
	           "FROM IssueDetails id JOIN Books b ON id.bookId = b.book_id " +
	           "WHERE id.mem_regno = :regNo AND id.returnDate IS NULL")
	 List<Object[]> findIssuedBooksByMember(@Param("regNo") Integer regNo);
	 
	 
	 @Query("SELECT id.issue_id, b.bookTitle, m.name, id.issueDate, id.dueDate, id.returnDate, id.fine " +
		       "FROM IssueDetails id " +
		       "JOIN Books b ON id.bookId = b.book_id " +
		       "JOIN Members m ON id.mem_regno = m.reg_no ")
	 List<Object[]> showIssueDetails();

}
