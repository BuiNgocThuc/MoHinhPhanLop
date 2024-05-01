/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.repository;

import com.project3.Member_Management_SpringBoot.model.Usage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author buing
 */
@Repository
public interface UsageRepository extends CrudRepository<Usage, Integer> {
    Usage findMemberById(Integer id);
    
    @Query("SELECT u FROM Usage u WHERE u.member.id = :memberId AND u.reserveTime IS NOT NULL")
    List<Usage> findByMemberIdAndReserveTimeNotNull(@Param("memberId") Integer memberId);
}
