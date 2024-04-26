/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.service.DisciplineService;
import com.project3.Member_Management_SpringBoot.service.DisciplineServiceImpl;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import com.project3.Member_Management_SpringBoot.service.MemberServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author buing
 */
@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/")
    public String home(Model theModel) {
        return "home";
    }

    @GetMapping("/loginPage")
    public String login(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "login";
    }

    @GetMapping("/registerPage")
    public String register(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "register";
    }

    @PostMapping("/authentication")
    public String authentication(@ModelAttribute("member") Member loginMember, HttpSession session, Model theModel) {
        Integer memberId = loginMember.getId();
        String password = loginMember.getPassword();
        if (!memberService.checkUserExists(memberId)) // kiểm tra ID có tồn tại không
        {
            return "redirect:/loginPage?errorUsername";
        }
        Member member = memberService.findById(memberId);
        if (!memberService.checkPasswordUser(member, password))
        {
            return "redirect:/loginPage?errorPassword";
        }
//        if (disciplineService.findStatusByMember(member) != null) {
//            return "redirect:/loginPage?isBlocked";
//        }
        session.setAttribute("user", member);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginPage?logout";
    }
}
