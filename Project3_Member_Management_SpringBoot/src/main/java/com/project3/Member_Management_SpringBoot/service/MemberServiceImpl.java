/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
public class MemberServiceImpl  implements MemberService{
    @Autowired
    private MemberRepository memberRepository;
    
    @Override
    public Member findById(Integer id) {
        return memberRepository.findById(id).get();
    }
    
    @Override
    public void saveMember(Member member){
        memberRepository.save(member);
    }
    
    @Override
    public Boolean checkPasswordUser(Member member,String password) {
        return member.getPassword().equals(password);
    }

    @Override
    public Boolean checkUserExists(Integer ID) {
        return memberRepository.findMemberById(ID) != null;
    }

    @Override
    public Member findByEmail(String email) {
        Optional<Member> optMember = memberRepository.findByEmail(email);
        return optMember.isPresent() ? optMember.get() : null;
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(members::add);
        return members;
    }

    @Override
    public void deleteById(Integer ID) {
        memberRepository.deleteById(ID);
    }
}
