package com.luminar.librarymanagement.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luminar.librarymanagement.entity.Books;
import com.luminar.librarymanagement.entity.IssueDetails;
import com.luminar.librarymanagement.entity.Members;
import com.luminar.librarymanagement.service.IssueBookService;

@Controller
public class IssueBooksController {

	@Autowired
	IssueBookService issueBookService;
	
	@GetMapping("/view-statistics")
    public ModelAndView getAllBooks() {
		List<Object[]> issuedBooks = issueBookService.showIssueDetails();
		ModelAndView mav = new ModelAndView("admin-statistics");
		mav.addObject("issueDetails", issuedBooks);
		return mav;
    }
	
	@GetMapping("/view-details")
	@ResponseBody
	public Map<String, Object> getBookAndMemberDetails(@RequestParam("bookId") Integer bookId,
			@RequestParam("memRegno") Integer memRegno) {
		
		System.out.println("Inside getBookAndMemberDetails method");
		Map<String, Object> response = new HashMap<>();
		
		Books book = issueBookService.findBookById(bookId);
		Members member = issueBookService.findMemberByRegNo(memRegno);

		if (book != null && member != null) {
			
			 if (member.getStatus().equalsIgnoreCase("INACTIVE")) {
	                response.put("success", false);
	                response.put("message", "The Member is Inactive, Please Renew Membership!");
	                return response;
	            }
			
			 int issuedBooksToMember = issueBookService.countIssuedBooksToMember(memRegno);
		        if (issuedBooksToMember >= 3) {
		            response.put("success", false);
		            response.put("message", "The member has already issued three books which haven't been returned yet.");
		            return response;
		        }
		        
			int issuedBooksCount = issueBookService.countIssuedBooksByBookId(bookId);
			if (issuedBooksCount < book.getTotalCopies()) {
				response.put("success", true);
				response.put("bookTitle", book.getBookTitle());
				response.put("memberName", member.getName());
				response.put("issueDate", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				response.put("dueDate", LocalDate.now().plusWeeks(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); 
			} else {
				response.put("success", false);
				response.put("message", "No copies of the book are currently available.");
			}
		} else {
			response.put("success", false);
			response.put("message", "Invalid Book ID or Member Registration Number");
		}

		return response;
	}
	
	@PostMapping("/issue-book")
    public ModelAndView issueBook(@RequestParam("bookId") Integer bookId,
                            @RequestParam("mem_regno") Integer memRegno) {
        issueBookService.issueBook(bookId, memRegno);

        Books book = issueBookService.findBookById(bookId);
        Members member = issueBookService.findMemberByRegNo(memRegno);
        ModelAndView modelAndView = new ModelAndView("issue-success");
        modelAndView.addObject("bookTitle", book.getBookTitle());
        modelAndView.addObject("memberName", member.getName());
        modelAndView.addObject("issueDate", LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        modelAndView.addObject("dueDate", LocalDate.now().plusWeeks(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        return modelAndView;

	}
	
	@GetMapping("/get-issued-books")
	@ResponseBody
    public List<Map<String, Object>> getIssuedBooks(@RequestParam("mem_regno") Integer memRegno) {
        return issueBookService.findIssuedBooksByMember(memRegno);
    }
	
	@GetMapping("/return-book")
    public ModelAndView showReturnBookPage(@RequestParam("issueId") Integer id) {
		
        IssueDetails issueDetail = issueBookService.findIssueDetailsById(id);
        Members member = issueBookService.findMemberByRegNo(issueDetail.getMemberRegNo());
        Books books = issueBookService.findBookById(issueDetail.getBookId());
        LocalDate dueDate = issueDetail.getDueDate();
        LocalDate currentDate = LocalDate.now();
        long daysOverdue = ChronoUnit.DAYS.between(dueDate,currentDate);
        double fine = 0;
        if(daysOverdue>0) {
        	fine = daysOverdue*3;
        }
        ModelAndView modelAndView = new ModelAndView("return-action");
        modelAndView.addObject("issueId", id);
        modelAndView.addObject("bookTitle", books.getBookTitle());
        modelAndView.addObject("memberName", member.getName());
        modelAndView.addObject("issueDate", issueDetail.getIssueDate() );
        modelAndView.addObject("dueDate", issueDetail.getDueDate());
        modelAndView.addObject("returnDate", currentDate );
        modelAndView.addObject("fine", fine);
        return modelAndView;
    }
	
	@GetMapping("/return")
	public String returnBook(@RequestParam("issueId") Integer issueId,
            @RequestParam("returnDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate returnDate,
            @RequestParam("fine") Double fine) {
			
		IssueDetails issueDetails = issueBookService.findIssueDetailsById(issueId);

		issueDetails.setReturnDate(returnDate);
		issueDetails.setFine(fine);

		issueBookService.returnBook(issueDetails);

		return "redirect:/home";
}


}
