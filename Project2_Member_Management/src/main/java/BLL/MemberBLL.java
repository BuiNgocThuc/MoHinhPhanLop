package BLL;

import DAL.MemberDAL;
import DAL.baseDAL;
import POJOs.Member;

import java.util.List;
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

    public Member getMemberById(int id) {
        return baseMemberDAL.getById(id);
    }

    public void insertMember(Member member) {
        baseMemberDAL.save(member);
    }

    public void updateMember(Member member) {
        baseMemberDAL.update(member);
    }

    public void deleteMember(int id) {
        baseMemberDAL.delete(id);
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
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        MemberBLL memberBLL = new MemberBLL();
        List<Member> members =memberBLL.selectAll();
        members.forEach(System.out::println);
        
    }
}
