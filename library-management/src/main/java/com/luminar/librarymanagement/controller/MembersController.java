package com.luminar.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luminar.librarymanagement.entity.Members;
import com.luminar.librarymanagement.service.MembersService;

@Controller
public class MembersController {
	
	@Autowired
    private MembersService membersService;
	
	@GetMapping("/view-members")
    public ModelAndView getAllMembers() {
		ModelAndView mav = new ModelAndView("admin-members");
		List<Members> membersList = membersService.getAllMembers();
		mav.addObject("membersList", membersList);
		return mav;
    }
	
	@GetMapping("/new-member")
	public ModelAndView addNewBookPageLoad() {
		ModelAndView mav = new ModelAndView("add-member");
		mav.addObject("member", new Members());
        return mav;
    }

	@PostMapping("/save-member")
	public String saveMember(@ModelAttribute Members member) {
		membersService.saveMember(member);
        return "redirect:/home";
    }
	
	@GetMapping("/delete-member")
	public String deleteMember(@RequestParam("id") Integer memberId) {
		membersService.deleteMemberById(memberId);
		return "redirect:/home";
	}
	
	@GetMapping("/edit-member")
    public ModelAndView showEditMemberPage(@RequestParam("id") Integer id) {
        Members member = membersService.getMemberById(id);
		ModelAndView mav = new ModelAndView("edit-member");
        mav.addObject("member", member);
        return mav; 
    }

    @PostMapping("/update-member/{id}")
    public String updateMember(@PathVariable("id") Integer id, @ModelAttribute Members member) {    	
        member.setReg_no(id); 
        membersService.updateMember(member);
        return "redirect:/home";
    }

}
