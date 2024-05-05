package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.model.PasswordResetToken;
import com.project3.Member_Management_SpringBoot.repository.TokenRepository;
import com.project3.Member_Management_SpringBoot.service.EmailService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TokenRepository tokenRepository;

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
        // return "redirect:/login?isBlocked";
        // }
        session.setAttribute("user", member);

        // FIXME: role should be retrieved from database
        String role = "user";
        if (memberId == 123456) {
            role = "admin";
        }
        session.setAttribute("role", role);
        return "redirect:/profile";
    }

    @GetMapping("/register")
    public String register(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "users/forgot-password";
    }

    @PostMapping("/forgotPassword")
    public String forgotPassordProcess(@ModelAttribute Member memberDTO) {
        try {
            String output = "";
            Member user = memberService.findByEmail(memberDTO.getEmail());
            if (user != null) {
                output = emailService.sendEmail(user);
            }
            if (output.equals("success"))
                return "redirect:/forgotPassword?success";
            else {
                System.out.println("Lỗi cc");
                return "redirect:/login?error";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/login?error";
        }
    }

    @GetMapping("/resetPassword/{token}")
    public String resetPasswordForm(@PathVariable String token, Model model) {
        PasswordResetToken reset = tokenRepository.findByToken(token);
        if (reset != null && emailService.hasExpired(reset.getExpiryDateTime())) {
            model.addAttribute("email", reset.getMember().getEmail());
            return "users/resetPassword";
        }
        return "redirect:/forgotPassword?error";
    }

    @PostMapping("/resetPassword")
    public String passwordResetProcess(@ModelAttribute Member memberDTO) {
        Member member = memberService.findByEmail(memberDTO.getEmail());
        if (member != null) {
            member.setPassword(memberDTO.getPassword());
            memberService.saveMember(member);
        }
        return "login";
    }

}
