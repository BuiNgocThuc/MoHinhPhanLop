/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.repository.DisciplineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
public class DisciplineServiceImpl {
    @Autowired
    private DisciplineRepository disciplineRepository;
    
    public Discipline findStatusByMember(Member member) {
        return disciplineRepository.findByMemberAndStatusAndDescriptionLike(member, 1, "%Khoa the%");
    }
    
    public List<Discipline> findByMember(Member member) {
        return disciplineRepository.findByMember(member);
    }
}
