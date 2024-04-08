package DAL;

import POJOs.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Utils.hibernateUtil;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

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
    
    public List<String> queryDepartment() {
        Transaction transaction = null;
        Session session;
        List<String> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "SELECT DISTINCT department FROM Member WHERE status <> 0";

            Query query = session.createQuery(hql);
            
            results = query.getResultList();

            transaction.commit();
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return results;
    }
    
    public List<String> queryMajorsByDeparment(String department) {
        Transaction transaction = null;
        Session session;
        List<String> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "SELECT DISTINCT major FROM Member WHERE department = :department AND status <> 0";

            Query query = session.createQuery(hql);
            query.setParameter("department", department);
            results = query.getResultList();

            transaction.commit();
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return results;
    }
}
