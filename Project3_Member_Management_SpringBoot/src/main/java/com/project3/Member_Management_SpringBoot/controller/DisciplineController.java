package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.service.DisciplineService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DisciplineController {
    private final DisciplineService disciplineService;
    @GetMapping("/disciplineList")
    public String getAllDiscipline() {

        return "admin/disciplineAdmin";
    }
    @GetMapping("/addDiscipline")
    public String addDiscipline(Model model) {
        return "admin/addDiscipline";
    }
}
