package com.luminar.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luminar.librarymanagement.service.BooksService;
import com.luminar.librarymanagement.service.MembersService;

@Controller
public class HomeController {
	
	@Autowired
	BooksService booksService;
	@Autowired
	MembersService membersService;
	
	@GetMapping("/")
	public String home() {
        return "index";
    }
	
    @GetMapping("/home") // Add this method to handle requests to /home
    public String showHomePage() {
        return "home"; // Assuming home.jsp is directly under webapp directory
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, 
                        @RequestParam("password") String password) {
        // Your login logic here
        if ("admin@gmail.com".equals(username) && "admin".equals(password)) {
            return "redirect:/home"; 
        } else {
            return "redirect:/?error=true"; 
        }
    }
    
    
    @RequestMapping("/welcome")
    public ModelAndView welcome() {
    	ModelAndView mav = new ModelAndView("admin-welcome");
    	int totalBooks = booksService.getTotalBooks();
    	long totalMembers = membersService.getTotalMembers();
    	mav.addObject("totalBooks", totalBooks);
    	mav.addObject("totalMembers",totalMembers);
    	return mav;
       // return "admin-welcome"; 
    }

    @RequestMapping("/books")
    public String books() {
        return "redirect:/view-books"; 
    }

    @RequestMapping("/statistics")
    public String statistics() {
        return "redirect:/view-statistics"; 
    }

    @RequestMapping("/members")
    public String members() {
        return "redirect:/view-members"; 
    }

    @RequestMapping("/book-issue")
    public String bookIssue() {
        return "book-issue"; 
    }

    @RequestMapping("/book-return")
    public String bookReturn() {
        return "book-return"; 
    }

    @RequestMapping("/book-search")
    public String bookSearch() {
        return "book-search"; 
    }
	
}
