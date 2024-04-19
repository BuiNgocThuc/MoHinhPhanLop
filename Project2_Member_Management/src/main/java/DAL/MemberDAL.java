package DAL;

import POJOs.Discipline;
import POJOs.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Utils.hibernateUtil;
import jakarta.persistence.Query;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberDAL {

    private SessionFactory sessionFactory;
    private baseDAL<Member> baseDAL;

    public MemberDAL() {
        sessionFactory = hibernateUtil.getSessionFactory();
        this.baseDAL = new baseDAL<>(Member.class);
    }

    public List<Member> statisticByDepartment(String department) {
        String hql = "FROM Member m\n"
                + "JOIN Usage u\n"
                + "WHERE u.enteredTime IS NOT NULL\n"
                + "AND m.department = :department";

        return baseDAL.statistic(hql, "department", department);
    }

//    public List<Member> statisticByMajor(String major) {
//        String hql = "FROM Member m\n"
//                + "JOIN Usage u\n"
//                + "WHERE u.enteredTime IS NOT NULL\n"
//                + "AND m.major = :major";
//
//        return baseDAL.statistic(hql, "major", major);
//    }
    public List<Member> timeBasedStatistics(String startDate, String endDate) {
        String hql = "FROM Member m\n"
                + "JOIN Usage u\n"
                + "WHERE u.enteredTime IS NOT NULL\n"
                + "AND u.enteredTime >= :startDate\n"
                + "AND u.enteredTime <= :endDate";

        return baseDAL.statistic(hql, "startDate", startDate, "endDate", endDate);
    }

    public List<String> queryYearOfActivation() {
        Transaction transaction = null;
        Session session;
        List<String> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "SELECT DISTINCT CONCAT('20', SUBSTR(CAST(id AS string), 2, 2)) year FROM Member";

            Query query = session.createQuery(hql, String.class);

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

    public void deleteByMemberID(String tableName, Member member) {
        Transaction transaction = null;
        Session session;
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "DELETE FROM " + tableName + " WHERE member = :member";

            Query query = session.createQuery(hql);
            query.setParameter("member", member);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Member> searchMember(String keyword) {
        Transaction transaction = null;
        Session session;
        List<Member> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM Member WHERE name LIKE :keyword OR id LIKE :keyword";

            Query query = session.createQuery(hql);
            query.setParameter("keyword", "%" + keyword + "%");
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

    public boolean checkViolation(Member member) {
        Transaction transaction = null;
        Session session;
        List<Discipline> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM Discipline WHERE memberID = :member";

            Query query = session.createQuery(hql);
            query.setParameter("member", member);
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
        for (Discipline discipline : results)
        {
            if (discipline.getStatus() == 1)
            {
                return true;
            }
        }
        return false;
    }
    
   public List<String> queryDepartments() {
        Transaction transaction = null;
        Session session;
        List<String> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT DISTINCT department FROM Member";
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

    public List<String> queryMajorsByDepartment(String department) {
        Transaction transaction = null;
        Session session;
        List<String> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT DISTINCT major FROM Member WHERE department = :department";
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

    public Long statisticByMajor(String major, Timestamp startDate, Timestamp endDate) {
        Long result = 0L; // Khởi tạo kết quả mặc định là 0
        try (Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            
            Map<String, Object> params = new HashMap<>();
            // Sử dụng truy vấn HQL để đếm số lượng
            String hql = "SELECT COUNT(*) FROM Usage u JOIN Member m ON u.member = m.id WHERE m.major = :major";
            params.put("major", major);
            if (startDate != null)
            {
                hql += " AND u.enteredTime >= :startDate";
                params.put("startDate", startDate);
            }
            if (endDate != null)
            {
                hql += " AND u.enteredTime <= :endDate";
                params.put("endDate", endDate);
            }

            org.hibernate.query.Query<Long> query = session.createQuery(hql, Long.class);
            for (Map.Entry<String, Object> entry : params.entrySet())
            {
                query.setParameter(entry.getKey(), entry.getValue());
            }

            // Sử dụng uniqueResult() để lấy kết quả duy nhất
            result = query.uniqueResult();

            // Hoàn thành giao dịch
            transaction.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // Trả về kết quả đếm
        return result;
    }
    
     public Long statisticByDepartment(String department, Timestamp startDate, Timestamp endDate) {
        Long result = 0L; // Khởi tạo kết quả mặc định là 0
        try (Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();
            
            Map<String, Object> params = new HashMap<>();
            // Sử dụng truy vấn HQL để đếm số lượng
            String hql = "SELECT COUNT(*) FROM Usage u JOIN Member m ON u.member = m.id WHERE m.department = :department";
            params.put("department", department);
            if (startDate != null)
            {
                hql += " AND u.enteredTime >= :startDate";
                params.put("startDate", startDate);
            }
            if (endDate != null)
            {
                hql += " AND u.enteredTime <= :endDate";
                params.put("endDate", endDate);
            }

            org.hibernate.query.Query<Long> query = session.createQuery(hql, Long.class);
            for (Map.Entry<String, Object> entry : params.entrySet())
            {
                query.setParameter(entry.getKey(), entry.getValue());
            }

            // Sử dụng uniqueResult() để lấy kết quả duy nhất
            result = query.uniqueResult();

            // Hoàn thành giao dịch
            transaction.commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // Trả về kết quả đếm
        return result;
    } 
}
