package com.luminar.librarymanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luminar.librarymanagement.entity.Books;
import com.luminar.librarymanagement.entity.IssueDetails;
import com.luminar.librarymanagement.entity.Members;
import com.luminar.librarymanagement.repository.BooksRepository;
import com.luminar.librarymanagement.repository.IssueDetailsRepository;
import com.luminar.librarymanagement.repository.MembersRepository;

@Service
public class IssueBookServiceImpl implements IssueBookService {

	@Autowired
	BooksRepository booksRepository;
	
	@Autowired
	MembersRepository membersRepository;
	
	@Autowired
	IssueDetailsRepository issueDetailsRepository;
	
	@Override
	public Books findBookById(Integer bookId) {
		return booksRepository.findById(bookId).orElse(null);
	}

	@Override
	public Members findMemberByRegNo(Integer regNo) {
		return membersRepository.findById(regNo).orElse(null);
	}

	@Override
	public void issueBook(Integer bookId, Integer regNo) {
				
				LocalDate issueDate = LocalDate.now();
				LocalDate dueDate = issueDate.plusWeeks(2);
				
				IssueDetails issueDetails = new IssueDetails();
				issueDetails.setBookId(bookId);
				issueDetails.setMemberRegNo(regNo);
				issueDetails.setIssueDate(issueDate);
				issueDetails.setDueDate(dueDate);
				issueDetailsRepository.save(issueDetails);
	}
	
	

	@Override
	public Integer countIssuedBooksByBookId(Integer bookId) {
		return issueDetailsRepository.countIssuedBooksByBookId(bookId);
	}

	@Override
	public Integer countIssuedBooksToMember(Integer memberId) {
		return issueDetailsRepository.countIssuedBooksToMember(memberId);
	}
	
    @Override
    public List<Map<String, Object>> findIssuedBooksByMember(Integer regNo) {
        List<Object[]> results = issueDetailsRepository.findIssuedBooksByMember(regNo);
        List<Map<String, Object>> issuedBooks = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> bookDetails = new HashMap<>();
            bookDetails.put("issueId", result[0]);
            bookDetails.put("bookTitle", result[1]);
            bookDetails.put("issueDate", result[2]);
            bookDetails.put("dueDate", result[3]);
            issuedBooks.add(bookDetails);
        }
        return issuedBooks;
    }

	@Override
	public IssueDetails findIssueDetailsById(Integer issueId) {
		return issueDetailsRepository.findById(issueId).orElse(null);
	}

	@Override
	public void returnBook(IssueDetails issueDetails) {
		issueDetailsRepository.save(issueDetails);
	}

	@Override
	public List<Object[]> showIssueDetails() {
		return issueDetailsRepository.showIssueDetails();
	}

}
