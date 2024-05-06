package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    
     @GetMapping("/membersList")
    public String getAllMembers(Model theModel) {
         List<Member> members = memberService.getAllMembers();
        theModel.addAttribute("data", members);
        return "admin/member-table";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "admin/memberForm";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("memberId") Integer ID, Model theModel) {
        Member member = memberService.findById(ID);
        theModel.addAttribute("member", member);
        return "admin/memberForm";
    }
    
    @PostMapping("/saveMember")
    public String saveMember(@ModelAttribute("member") Member member) {
        memberService.saveMember(member);
        return "redirect:/admin/members/list";
    }
    
    @GetMapping("/deleteMember")
    public String deleteMember(@RequestParam("memberId") Integer ID) {
        memberService.deleteById(ID);
        return "redirect:/admin/members/list";
    }
    
}
