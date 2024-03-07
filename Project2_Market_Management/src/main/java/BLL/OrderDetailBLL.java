package BLL;

import DAL.Order;
import DAL.OrderDetail;
import DAL.OrderDetailDAL;
import DAL.Vegetable;

import java.util.List;

public class OrderDetailBLL {
    private OrderDetailDAL orderDetailDAL;

    public OrderDetailBLL() {
        orderDetailDAL = new OrderDetailDAL();
    }

    @SuppressWarnings("rawtypes")
    public List loadOrderDetails() {
        List list;
        list = orderDetailDAL.loadOrderDetails();

        return list;
    }

    public Object[][] convertList(List<OrderDetail> list) {
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getOrder().getId();
            obj[i][1] = list.get(i).getVegetable().getId();
            obj[i][2] = list.get(i).getQuantity();
            obj[i][3] = list.get(i).getPrice();
        }
        return obj;
    }

    public OrderDetail getOrderDetail(Order order, Vegetable vegetable) {
        OrderDetail orderDetail = orderDetailDAL.getOrderDetail(order, vegetable);
        return orderDetail;
    }

    public void newOrderDetail(OrderDetail orderDetail) {
        orderDetailDAL.addOrderDetail(orderDetail);
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailDAL.updateOrderDetail(orderDetail);
    }

    public void deleteOrderDetail(OrderDetail orderDetail) {
        orderDetailDAL.deleteOrderDetail(orderDetail);
    }
}
