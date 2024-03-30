package DAL;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Utils.hibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class baseDAL<T> {

    private SessionFactory sessionFactory;
    private Class<T> clazz;

    public baseDAL(Class<T> clazz) {
        this.clazz = clazz;
        this.sessionFactory = hibernateUtil.getSessionFactory();
    }

    public List<T> selectAll() {
        try (Session session = sessionFactory.openSession())
        {
            return session.createQuery("from " + clazz.getName(), clazz).list();
        }
    }

    public T getById(int id) {
        try (Session session = sessionFactory.openSession())
        {
            return session.get(clazz, id);
        }
    }

    public void save(T object) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession())
        {
            transaction = session.beginTransaction();
            session.persist(object);
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

    public void update(T object) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession())
        {
            transaction = session.beginTransaction();
            session.merge(object);
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

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession())
        {
            transaction = session.beginTransaction();

            String hql = "UPDATE " + clazz.getName() + " set status = :active " + "WHERE id = :ID";
            Query query = session.createQuery(hql);
            query.setParameter("active", 0);
            query.setParameter("ID", id);
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

    public List<T> statistic(String hql) {
        Transaction transaction = null;
        Session session;
        List<T> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

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
}
