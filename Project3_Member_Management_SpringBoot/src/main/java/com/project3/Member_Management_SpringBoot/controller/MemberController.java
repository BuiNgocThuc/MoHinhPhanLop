package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.annotation.AuthRequire;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    
     @GetMapping("/membersList")
     @AuthRequire
    public String getAllMembers(Model theModel) {
         List<Member> members = memberService.getAllMembers();
        theModel.addAttribute("data", members);
        return "admin/membersList";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "admin/memberForm";
    }
    
    @GetMapping("/showFormForUpdate")
    @AuthRequire
    public String showFormForUpdate(@RequestParam("memberId") Integer ID, Model theModel) {
        Member member = memberService.findById(ID);
        theModel.addAttribute("member", member);
        return "admin/memberForm";
    }
    
    @PostMapping("/saveMember")
    public String saveMember(@ModelAttribute("member") Member member) {
        memberService.saveMember(member);
        return "redirect:/memberlist";
    }
    
    @GetMapping("/deleteMember")
    @AuthRequire
    public String deleteMember(@RequestParam("memberId") Integer ID) {
        memberService.deleteById(ID);
        return "redirect:/memberlist";
    }
    
}
