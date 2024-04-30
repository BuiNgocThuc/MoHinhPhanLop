/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import com.project3.Member_Management_SpringBoot.service.MemberServiceImpl;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author buing
 */
@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/save")
    public String saveMember(@ModelAttribute("member") Member member) {
        memberService.saveMember(member);
        return "redirect:/loginPage?successSignUp";
    }
    
    @GetMapping("/profile")
    public String showProfile() {
        return "users/change-password";
    }
    @GetMapping("/detailborrowed/{userId}")
    public String showDeviceBorrowed(@PathVariable("userId") String userId, Model model) {
        Member member=memberService.findById(Integer.parseInt(userId));
        Iterable<Usage> borrowedDevices=member.getUsages();
        if (member == null) {
        return "error";
        }
        model.addAttribute("borrowedDevices", borrowedDevices);
        return "users/detail-borrowed-device";
    }
    
    @PostMapping("/changePassword")
    public String changePassword( HttpSession session,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        Member member = (Member) session.getAttribute("user");
        if(!memberService.checkPasswordUser(member, oldPassword)) {
            return "redirect:/members/profile?wrongOldPassword";
        }
        member.setPassword(newPassword);
        memberService.saveMember(member);
        return "redirect:/members/profile?changePasswordSuccess";
    }
}
