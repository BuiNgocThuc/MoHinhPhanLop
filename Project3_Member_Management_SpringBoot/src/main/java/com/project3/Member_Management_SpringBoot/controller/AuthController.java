package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("member") Member loginMember, HttpSession session, Model theModel) {
        Integer memberId = loginMember.getId();
        String password = loginMember.getPassword();
        if (!memberService.checkUserExists(memberId)) // kiểm tra ID có tồn tại không
        {
            return "redirect:/login?errorUsername";
        }
        Member member = memberService.findById(memberId);
        if (!memberService.checkPasswordUser(member, password)) {
            return "redirect:/login?errorPassword";
        }
        // if (disciplineService.findStatusByMember(member) != null) {
        // return "redirect:/loginPage?isBlocked";
        // }
        session.setAttribute("user", member);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        return "redirect:/login?logout";
    }
}
