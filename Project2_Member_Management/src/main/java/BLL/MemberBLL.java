package BLL;

import DAL.MemberDAL;
import DAL.baseDAL;
import POJOs.Member;
import POJOs.Device;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberBLL {

    private baseDAL<Member> baseMemberDAL;
    private MemberDAL memberDAL;

    public MemberBLL() {
        this.memberDAL = new MemberDAL();
        this.baseMemberDAL = new baseDAL<>(Member.class);
    }

    public List<Member> selectAll() {
        return baseMemberDAL.selectAll();
    }

    public <String> Member getMemberById(int id) {
        return baseMemberDAL.getById(id);
    }

    public void insertMember(Member member) {
        baseMemberDAL.save(member);
    }

    public void updateMember(Member member) {
        baseMemberDAL.update(member);
    }

    public void deleteMember(int id) {
        Member member = getMemberById(id);
//        deleteByMemberID("Usage", id);
//        deleteByMemberID("Discipline", id);
        baseMemberDAL.delete(member);
    }
    
    public List<Member> searchMember(String keyword) {
        String validKeyword = keyword.trim().toLowerCase();
        return memberDAL.searchMember(validKeyword);
    }
    
    public void deleteByMemberID(String tableName, int id) {
        Member member = getMemberById(id);
        memberDAL.deleteByMemberID(tableName, member);
    }
    
    public boolean checkViolation(Member member) {
        return memberDAL.checkViolation(member);
    }

    public List<Member> statisticByDepartment(String department) {
        return memberDAL.statisticByDepartment(department);
    }

    public List<Member> statisticByMajor(String major) {
        return memberDAL.statisticByMajor(major);
    }

    public List<Member> timeBasedStatistics(String startDate, String endDate) {
        return memberDAL.timeBasedStatistics(startDate, endDate);
    }
    
    public List<String> queryYearOfActivation() {
//        return memberDAL.queryYearOfActivation();
        List<Member> members = selectAll();
        Set<String> yearsOfActivation = new HashSet<>();
        for(Member member : members) {
            int memberID = member.getId();
            String year = "20" + String.valueOf(memberID).substring(1, 3);
            yearsOfActivation.add(year);
        }
        List<String> list = new ArrayList<>(yearsOfActivation);
        
        Collections.sort(list);
        return list;
    }
    
    public void deleteMemberByActiveYear(String year) {
        String subID = year.substring(2);
        List<Member> memberList = selectAll();
        for (Member member : memberList)
        {
            int memberID = member.getId();
            String memberIDStr = String.valueOf(memberID).substring(1,3);
            if(subID.equals(memberIDStr)) {
                deleteMember(memberID);
            }
        }
    }
    
//    public List<String> queryDepartment() {
//        return memberDAL.queryDepartment();
//    }
//    
//    public List<String> queryMajor(String department) {
//        return memberDAL.queryMajorsByDeparment(department);
//    }
}
