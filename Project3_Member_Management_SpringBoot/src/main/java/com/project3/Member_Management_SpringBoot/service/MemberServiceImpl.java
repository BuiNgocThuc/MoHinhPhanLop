/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.service;

import com.project3.Member_Management_SpringBoot.model.Device;
import com.project3.Member_Management_SpringBoot.model.Discipline;
import com.project3.Member_Management_SpringBoot.model.Member;
import com.project3.Member_Management_SpringBoot.repository.MemberRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member findById(Integer id) {
        return memberRepository.findById(id).get();
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Boolean checkPasswordUser(Member member, String password) {
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

    @Override
    public void deleteByActiveYear(String activeYear) {
        String subID = activeYear.substring(2);
        List<Member> memberList = getAllMembers();
        for (Member member : memberList)
        {
            int memberID = member.getId();
            String memberIDStr = String.valueOf(memberID).substring(1, 3);
            if (subID.equals(memberIDStr))
            {
                deleteById(memberID);
            }
        }
    }

    @Override
    public Integer statisticsMember(String department, String major, Date startDate, Date endDate) {
        Timestamp startDateTimestamp = null;
        Timestamp endDateTimestamp = null;
        if (startDate != null)
        {
            startDateTimestamp = new Timestamp(startDate.getTime());
        }
        if (endDate != null)
        {
            endDateTimestamp = new Timestamp(endDate.getTime());
        }
        List<Member> members = memberRepository.statisticsMember(department, major, startDateTimestamp, endDateTimestamp);

        return members.size();
    }
}
