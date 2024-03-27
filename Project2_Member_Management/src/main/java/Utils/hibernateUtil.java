/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import POJOs.*;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author buing
 */
public class hibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        Configuration conf = new Configuration();
        Properties pros = new Properties();
        pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        pros.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        pros.put(Environment.URL, "jdbc:mysql://localhost:3306/qlthanhvien");
        pros.put(Environment.USER, "root");
        pros.put(Environment.PASS, "");
        pros.put(Environment.SHOW_SQL, false);
        pros.put(Environment.GLOBALLY_QUOTED_IDENTIFIERS, true);
        pros.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS,true);

        conf.setProperties(pros);

        conf.addAnnotatedClass(Member.class);
        conf.addAnnotatedClass(Device.class);
        conf.addAnnotatedClass(Usage.class);
        conf.addAnnotatedClass(Discipline.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();

        sessionFactory = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
