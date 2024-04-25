/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringWeb.service;

import SpringWeb.model.Member;
import SpringWeb.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buing
 */
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        memberRepository.findAll().forEach(members::add);
        return members;
    }

    public Member findById(Integer id) {
        return memberRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        memberRepository.deleteById(id);
    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }
}
