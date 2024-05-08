/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.repository;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author buing
 */
@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

    Member findMemberById(Integer id);

    Optional<Member> findByEmail(String email);

    @Query("SELECT m FROM Usage u JOIN u.member m WHERE (:department IS NULL OR m.department = :department) AND (:major IS NULL OR m.major = :major) AND u.enteredTime IS NOT NULL AND (:startDate IS NULL OR u.enteredTime >= :startDate) AND (:endDate IS NULL OR u.enteredTime <= :endDate)")
    List<Member> statisticsMember(@Param("department") String department, @Param("major") String major, @Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
}
