/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.annotation.RestrictTo;
import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.service.DeviceService;
import com.project3.Member_Management_SpringBoot.service.DeviceServiceImpl;
import com.project3.Member_Management_SpringBoot.service.DisciplineService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
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
    
    @Autowired
    private DeviceService deviceService;
    
    @GetMapping("/")
    @RestrictTo({"user"})
    public String home(Model theModel) {
        return "users/profile";
    }

    @GetMapping("/login")
    public String login(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "login";
    }

    @GetMapping("/reservation")
    @RestrictTo({"user"})
    public String reservation(Model theModel) {
        return "users/reservation";
    }
    
     @GetMapping("/reservation_test")
    @RestrictTo({"user"})
    public String reservation_test(Model theModel) {
         List<Device> availableDevices = deviceService.getAvailableDevices();
        theModel.addAttribute("availableDevices", availableDevices);
         Usage usage = new Usage();
        theModel.addAttribute("usage", usage);
        return "users/reservation_test";
    }

    @GetMapping("/profile")
    @RestrictTo({"user"})
    public String user() {
        return "users/profile";
    }

    @GetMapping("/register")
    public String register(Model theModel) {
        Member member = new Member();
        theModel.addAttribute("member", member);
        return "register";
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
//        if (disciplineService.findStatusByMember(member) != null) {
//            return "redirect:/loginPage?isBlocked";
//        }
        session.setAttribute("user", member);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}
