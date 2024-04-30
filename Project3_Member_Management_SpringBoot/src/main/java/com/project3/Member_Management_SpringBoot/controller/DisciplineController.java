/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.service.DisciplineService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author buing
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/disciplines")
public class DisciplineController {
    
    private final DisciplineService  disciplineService;
    
    @GetMapping("/violation_history")
    public String violationHistory(HttpSession session, Model theModel) {
        Member member = (Member) session.getAttribute("user");
        List<Discipline> disciplinesByUser = disciplineService.findByMember(member);
        
        theModel.addAttribute("data", disciplinesByUser);
        return "users/violation-history";
    }
}
