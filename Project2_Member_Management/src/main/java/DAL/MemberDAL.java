package DAL;

import POJOs.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Utils.hibernateUtil;

import java.util.List;

public class MemberDAL {
    private SessionFactory sessionFactory;
    private baseDAL<Member> baseDAL;

    public MemberDAL() {
        sessionFactory = hibernateUtil.getSessionFactory();
        this.baseDAL = new baseDAL<>(Member.class);
    }
    public List<Member> statisticByDepartment(String department) {
        String hql = "FROM Member m\n" +
                "JOIN Usage u\n" +
                "WHERE u.enteredTime IS NOT NULL\n" +
                "AND m.department = :department";
        
        return baseDAL.statistic(hql, "department", department);
    }

    public List<Member> statisticByMajor(String major) {
        String hql = "FROM Member m\n" +
                "JOIN Usage u\n" +
                "WHERE u.enteredTime IS NOT NULL\n" +
                "AND m.major = :major";

        return baseDAL.statistic(hql, "major", major);
    }

    public List<Member> timeBasedStatistics(String startDate, String endDate) {
        String hql = "FROM Member m\n" +
                "JOIN Usage u\n" +
                "WHERE u.enteredTime IS NOT NULL\n" +
                "AND u.enteredTime >= :startDate\n" +
                "AND u.enteredTime <= :endDate";

        return baseDAL.statistic(hql, "startDate", startDate, "endDate", endDate);
    }
}
