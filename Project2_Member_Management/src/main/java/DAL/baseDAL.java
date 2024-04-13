package DAL;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Utils.hibernateUtil;
import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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

    public <K> T getById(K id) {
        try (Session session = sessionFactory.openSession())
        {
            return session.get(clazz, id);
        }
    }

    public void save(T object) {
        Transaction transaction = null;
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
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
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
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

    public void delete(T object) {
        Transaction transaction = null;
        Session session = null;
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(object);
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

    public List<T> statistic(String hql, Object... params) {
        Transaction transaction = null;
        Session session;
        List<T> results = new ArrayList<>();
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery(hql);
            for (int i = 0; i < params.length; i += 2)
            {
                query.setParameter((String) params[i], params[i + 1]);
            }
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
