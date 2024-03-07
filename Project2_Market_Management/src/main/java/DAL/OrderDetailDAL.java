package DAL;

import java.util.List;
import org.hibernate.Session;

public class OrderDetailDAL {
    Session session;

    public OrderDetailDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadOrderDetails() {
        List<OrderDetail> orderDetails;
        session.beginTransaction();
        orderDetails = session.createQuery("FROM OrderDetail", OrderDetail.class).list();
        session.getTransaction().commit();
        return orderDetails;
    }

    public OrderDetail getOrderDetail(Order order, Vegetable vegetable) {
        OrderDetail orderDetail = (OrderDetail) session
                .createQuery("FROM OrderDetail WHERE order = :order AND vegetable = :vegetable")
                .setParameter("order", order)
                .setParameter("vegetable", vegetable)
                .uniqueResult();
        return orderDetail;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        session.save(orderDetail);
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        session.beginTransaction();
        session.update(orderDetail);
        session.getTransaction().commit();
    }

    public void deleteOrderDetail(OrderDetail orderDetail) {
        session.beginTransaction();
        session.delete(orderDetail);
        session.getTransaction().commit();
    }
}
