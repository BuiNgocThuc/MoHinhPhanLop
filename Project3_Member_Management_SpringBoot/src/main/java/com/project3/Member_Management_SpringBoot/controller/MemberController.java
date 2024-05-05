package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Email;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.service.EmailService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private EmailService emailService;

    @PostMapping("/save")
    public String saveMember(@ModelAttribute("member") Member member) {
        memberService.saveMember(member);
        return "redirect:/login?successSignUp";
    }

    // @GetMapping("/profile")
    // public String showProfile() {
    // return "users/change-password";
    // }

    @PostMapping("/changePassword")
    public String changePassword(HttpSession session,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        Member member = (Member) session.getAttribute("user");
        if (!memberService.checkPasswordUser(member, oldPassword)) {
            return "redirect:/members/profile?wrongOldPassword";
        }
        member.setPassword(newPassword);
        memberService.saveMember(member);
        return "redirect:/members/profile?changePasswordSuccess";
    }

    @PostMapping(value = "/send-email")
    public void sendEmail(@RequestBody Member member) throws Exception {
        try {
            emailService.sendEmail(member);
        } catch (Exception e) {
            throw new Exception();
        }

    }
}
