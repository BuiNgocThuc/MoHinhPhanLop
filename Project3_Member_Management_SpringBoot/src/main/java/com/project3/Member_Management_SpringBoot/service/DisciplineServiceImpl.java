/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.repository.DisciplineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**

 *
 * @author buing
 */
@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public Discipline findStatusByMember(Member member) {
        return disciplineRepository.findByMemberAndStatusAndDescriptionLike(member, 1, "%Khoa the%");
    }

    @Override
    public List<Discipline> findByMember(Member member) {
        return disciplineRepository.findByMember(member);
    }

    @Override
    public Integer findByStatus(Integer status) {
        List<Discipline> disciplines = disciplineRepository.findByStatus(status);
        return disciplines.size();
    }

    @Override
    public Integer findSumFine() {
        return disciplineRepository.findSumFine();
    }
    public List<Discipline> getAllDiscipline() {
        return (List<Discipline>)disciplineRepository.findAll();
    }    

    @Override
    public void saveDiscipline(Discipline discipline) {
        disciplineRepository.save(discipline);
    }
    
    @Override
    public Discipline findById(Integer id) {
        return disciplineRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteById(Integer id) {
        disciplineRepository.deleteById(id);
    }

    @Override
    public Boolean checkViolate(Member member, Integer status) {
        List<Discipline> hasViolated = disciplineRepository.findByMemberAndStatus(member, status);
        return !hasViolated.isEmpty();
    }

}
