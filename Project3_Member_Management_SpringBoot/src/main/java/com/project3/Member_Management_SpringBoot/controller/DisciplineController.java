package com.project3.Member_Management_SpringBoot.controller;

import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.service.DisciplineService;
import com.project3.Member_Management_SpringBoot.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class DisciplineController {
    private final DisciplineService disciplineService;
    private final MemberService memberService;
    @GetMapping("/admin/disciplineList")
    public String getAllDiscipline(Model model) {
        Iterable<Discipline> disciplineList=disciplineService.getAllDiscipline();
        model.addAttribute("disciplineList",disciplineList);
        return "admin/disciplineAdmin";
    }
    @GetMapping("/admin/disciplineList/addDiscipline")
    public String addDiscipline(Model model) {
        Iterable<Member> members=memberService.getAllMembers();
        model.addAttribute("memberList", members);
        model.addAttribute("discipline", new Discipline());
        return "admin/addDiscipline";
    }
    @RequestMapping(value="save",method = RequestMethod.POST)
    public String save(Discipline discipline){
        disciplineService.saveDiscipline(discipline);
        return "redirect:/admin/disciplineList";
    }
}
