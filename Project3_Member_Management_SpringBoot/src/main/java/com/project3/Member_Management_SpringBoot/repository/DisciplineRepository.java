/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.repository;

import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author buing
 */
@Repository
public interface DisciplineRepository extends CrudRepository<Discipline, Integer>{
    Discipline findByMemberAndStatusAndDescriptionLike(Member member, Integer status, String description);
    List<Discipline> findByMember(Member member);
    
    List<Discipline> findByStatus(Integer status);
    
    @Query("SELECT SUM(d.fine) FROM Discipline d WHERE d.status = 0")
    Integer findSumFine();
    
    List<Discipline> findByMemberAndStatus(Member member, Integer status);
}
