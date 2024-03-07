package BLL;

import DAL.Order;
import DAL.OrderDAL;
import java.util.List;

public class OrderBLL {
    private OrderDAL orderDAL;

    public OrderBLL() {
        orderDAL = new OrderDAL();
    }

    @SuppressWarnings("rawtypes")
    public List loadOrders() {
        List list;
        list = orderDAL.loadOrders();

        return list;
    }

    public Object[][] convertList(List<Order> list) {
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getId();
            obj[i][1] = list.get(i).getDate();
            obj[i][2] = list.get(i).getTotal();
            obj[i][3] = list.get(i).getNote();
        }
        return obj;
    }

    public Order getOrder(int orderId) {
        Order order = orderDAL.getOrder(orderId);
        return order;
    }

    public void newOrder(Order order) {
        orderDAL.addOrder(order);
    }

    public void updateOrder(Order order) {
        orderDAL.updateOrder(order);
    }

    public void deleteOrder(int orderId) {
        orderDAL.deleteOrder(orderId);
    }
}
