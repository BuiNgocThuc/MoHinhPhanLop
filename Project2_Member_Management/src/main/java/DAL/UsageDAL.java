/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import org.hibernate.SessionFactory;
import POJOs.Usage;
import POJOs.Member;
import POJOs.Device;
import Utils.hibernateUtil;
import jakarta.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author buing
 */
public class UsageDAL {

    private SessionFactory sessionFactory;
    private baseDAL<Usage> baseDAL;

    public UsageDAL() {
        sessionFactory = hibernateUtil.getSessionFactory();
        this.baseDAL = new baseDAL<>(Usage.class);
    }

    public List<Usage> selectByMemberID(Member member) {
        Transaction transaction = null;
        Session session;
        List<Usage> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            String hql = "FROM Usage Where member = :member AND device <> null";
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
        return results;
    }
    
    public List<Device> selectAvailableDevices() {
        Transaction transaction = null;
        Session session;
        List<Device> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            String hql = "FROM Device d "
                    + "LEFT JOIN Usage u "
                    + "ON d.id = u.device "
                    + "AND u.paidTime IS NULL "
                    + "WHERE u.device IS NULL";
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
    
    public void updateByBorrowedTime(Timestamp borrowedTime, Timestamp paidTime, Device device) {
        Transaction transaction = null;
        Session session;
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "UPDATE Usage SET paidTime = :paidTime WHERE borrowedTime = :borrowedTime AND device = :device";

            Query query = session.createQuery(hql);
            query.setParameter("borrowedTime", borrowedTime);
            query.setParameter("paidTime", paidTime);
            query.setParameter("device", device);
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
}
