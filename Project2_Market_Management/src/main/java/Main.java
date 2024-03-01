
import DAL.Category;
import DAL.Customers;
import DAL.HibernateUtils;
import DAL.Order;
import DAL.OrderDetail;
import DAL.Vegetable;
import java.util.Date;
import org.hibernate.Session;



public class Main {
    public static void main(String[] args) {
        Session ss = HibernateUtils.getSessionFactory().openSession();
//        Customers c = new Customers();
//        c.setPassword("123");
//        c.setAddress("BĐ");
//        c.setFullname("Tuan");
//        c.setCity("HCM");
//        ss.save(c);
//        ss.close();
        OrderDetail v = new OrderDetail();
        Order o = ss.get(Order.class, 1);
        v.setOrder(o);
        Vegetable g = ss.get(Vegetable.class, 1);
        v.setVegetable(g);
        v.setQuantity(2);
        v.setPrice(2000.0);
        ss.beginTransaction();
        ss.save(v);
        ss.getTransaction().commit();
        ss.close();
    }
}
