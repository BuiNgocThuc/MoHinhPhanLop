package DAL;

import java.util.List;
import org.hibernate.Session;

public class OrderDAL {
    Session session;

    public OrderDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    @SuppressWarnings("rawtypes")
    public List loadOrders() {
        List<Order> orders;
        session.beginTransaction();
        orders = session.createQuery("FROM Order", Order.class).list();
        session.getTransaction().commit();
        return orders;
    }

    public Order getOrder(int orderId) {
        Order order = session.get(Order.class, orderId);
        return order;
    }

    public void addOrder(Order order) {
        session.save(order);
    }

    public void updateOrder(Order order) {
        Order orderToUpdate = session.get(Order.class, order.getId());
        if (orderToUpdate != null) {
            orderToUpdate.setDate(order.getDate());
            orderToUpdate.setTotal(order.getTotal());
            orderToUpdate.setNote(order.getNote());
            orderToUpdate.setCustomer(order.getCustomer());

            session.beginTransaction();
            session.update(orderToUpdate);
            session.getTransaction().commit();
        }
    }

    public void deleteOrder(int orderId) {
        Order orderToDelete = session.get(Order.class, orderId);
        if (orderToDelete != null) {
            session.beginTransaction();
            session.delete(orderToDelete);
            session.getTransaction().commit();
        }
    }
}
