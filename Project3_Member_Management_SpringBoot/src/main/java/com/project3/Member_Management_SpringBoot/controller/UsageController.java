/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.model.Usage;
import com.project3.Member_Management_SpringBoot.service.UsageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author buing
 */
@Controller
public class UsageController {
    
    @Autowired
    private UsageService usageService;
    
    @PostMapping("/reservation")
    public String reserseDevice(@ModelAttribute("usage") Usage usage, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        
        usage.setMember(member);
        Boolean reserve = usageService.reserveDevice(usage);
        if (reserve)
        {
            return "redirect:/reservation_test?success";
        }
        return "redirect:/reservation_test?unavailable";
    }
    
}
