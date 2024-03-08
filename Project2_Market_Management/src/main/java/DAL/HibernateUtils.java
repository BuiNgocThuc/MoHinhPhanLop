
package DAL;

import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtils {
    private static final SessionFactory FACTORY;

    static {
        try {
            Configuration conf = new Configuration();

            Properties prop = new Properties();
            prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            prop.put(Environment.URL, "jdbc:mysql://localhost:3306/test_hibernate");
            prop.put(Environment.USER, "root");
            prop.put(Environment.PASS, "");
            prop.put(Environment.SHOW_SQL, "true");

            conf.setProperties(prop);
            conf.addAnnotatedClass(Category.class);
            conf.addAnnotatedClass(Vegetable.class);
            conf.addAnnotatedClass(Order.class);
            conf.addAnnotatedClass(Customers.class);

            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties())
                    .build();

            FACTORY = conf.buildSessionFactory(registry);
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Error initializing Hibernate: " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
    
     public static void shutdown() {
        if (FACTORY != null) {
            FACTORY.close();
        }
    }
}
