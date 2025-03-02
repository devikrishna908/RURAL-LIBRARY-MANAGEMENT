package com.luminar.librarymanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="issue_details")
public class IssueDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issue_id;
    
    @Column(name = "reg_no")
    private Integer mem_regno;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "fine")
    private double fine;

	public IssueDetails() {
	}

	public IssueDetails(Integer issue_id, Integer memberRegNo, Integer bookId, LocalDate issueDate, LocalDate dueDate,
			LocalDate returnDate, double fine) {
		this.issue_id = issue_id;
		this.mem_regno = memberRegNo;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}

	public Integer getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(Integer issue_id) {
		this.issue_id = issue_id;
	}

	public Integer getMemberRegNo() {
		return mem_regno;
	}

	public void setMemberRegNo(Integer memberRegNo) {
		this.mem_regno = memberRegNo;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

}
