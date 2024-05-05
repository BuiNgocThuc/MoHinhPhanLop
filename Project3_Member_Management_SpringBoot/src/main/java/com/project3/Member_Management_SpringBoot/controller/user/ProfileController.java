package com.project3.Member_Management_SpringBoot.controller.user;

import com.project3.Member_Management_SpringBoot.annotation.AuthRequire;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.service.DisciplineService;
import com.project3.Member_Management_SpringBoot.service.EmailService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class ProfileController {

    @Autowired
    private MemberService memberService;
    private EmailService emailService;
    private DisciplineService disciplineService;


    @PostMapping("/changePassword")
    public String changePassword(HttpSession session,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword) {
        Member member = (Member) session.getAttribute("user");
        if (!memberService.checkPasswordUser(member, oldPassword))
        {
            return "redirect:/?wrongOldPassword";
        }
        member.setPassword(newPassword);
        memberService.saveMember(member);
        return "redirect:/?changePasswordSuccess";
    }

    @PostMapping(value = "/send-email")
    public void sendEmail(@RequestBody Member member) throws Exception {
        try
        {
            emailService.sendEmail(member);
        } catch (Exception e)
        {
            throw new Exception();
        }
    }

    @GetMapping("/violation_history")
    @AuthRequire
    public String violationHistory(HttpSession session, Model theModel) {
        Member member = (Member) session.getAttribute("user");
        List<Discipline> disciplinesByUser = disciplineService.findByMember(member);

        theModel.addAttribute("data", disciplinesByUser);
        return "users/violation-history";
    }
}
