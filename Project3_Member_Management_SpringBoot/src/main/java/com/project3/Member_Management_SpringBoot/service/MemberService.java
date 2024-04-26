/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Member;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author buing
 */
public interface MemberService {
    @Autowired
    Member findById(Integer id);
    void saveMember(Member member);
    Boolean checkPasswordUser(Member member,String password);
    Boolean checkUserExists(Integer ID);
}
