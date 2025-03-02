package com.luminar.librarymanagement.service;


import java.util.List;
import java.util.Map;

import com.luminar.librarymanagement.entity.Books;
import com.luminar.librarymanagement.entity.IssueDetails;
import com.luminar.librarymanagement.entity.Members;

public interface IssueBookService {
	
	public Books findBookById(Integer bookId);
	
	public Members findMemberByRegNo(Integer regNo);
	
	public IssueDetails findIssueDetailsById(Integer issueId);
	
	public void issueBook(Integer bookId, Integer regNo);
	
	public Integer countIssuedBooksByBookId(Integer bookId);

	public Integer countIssuedBooksToMember(Integer memberId);
	
	public List<Map<String, Object>> findIssuedBooksByMember(Integer regNo);
	
	public void returnBook(IssueDetails issueDetails) ;

	public List<Object[]> showIssueDetails();
}
