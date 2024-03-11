package BLL;

import DAL.Customers;
import DAL.CustomersDAL;
import java.util.List;

public class CustomersBLL {
    private CustomersDAL customerDAL;

    public CustomersBLL() {
        customerDAL = new CustomersDAL();
    }

    @SuppressWarnings("rawtypes")
    public List loadCustomers() {
        List list;
        list = customerDAL.loadCustomers();

        return list;
    }

    public Object[][] convertList(List<Customers> list) {
        int rows = list.size();
        int cols = 4;
        Object[][] obj = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            obj[i][0] = list.get(i).getId();
            obj[i][1] = list.get(i).getPassword();
            obj[i][2] = list.get(i).getFullname();
            obj[i][3] = list.get(i).getAddress();
            obj[i][4] = list.get(i).getCity();
        }
        return obj;
    }

    public Customers getCustomer(int customerId) {
        Customers customer = customerDAL.getCustomers(customerId);
        return customer;
    }

    public void newCustomer(Customers customer) {
        customerDAL.addCustomers(customer);
    }

    public void updateCustomer(Customers customer) {
        customerDAL.updateCustomers(customer);
    }

    public void deleteCustomer(int id) {
        customerDAL.deleteCustomers(id);
    }

    public void resetPassword(int customerId) {
        Customers customer = getCustomer(customerId);
        customer.setPassword("Abcd1234");
        updateCustomer(customer);
    }
}
