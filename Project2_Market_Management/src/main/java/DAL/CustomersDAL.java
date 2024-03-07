package DAL;

import java.util.List;
import org.hibernate.Session;

public class CustomersDAL {
    Session session;

    public CustomersDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    @SuppressWarnings("rawtypes")
    public List loadCustomers() {
        List<Customers> customers;
        session.beginTransaction();
        customers = session.createQuery("FROM Customers", Customers.class).list();
        session.getTransaction().commit();
        return customers;
    }

    public Customers getCustomers(int customerId) {
        Customers customer = session.get(Customers.class, customerId);
        return customer;
    }

    public void addCustomers(Customers customer) {
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    public void updateCustomers(Customers customer) {
        Customers customerToUpdate = session.get(Customers.class, customer.getId());
        if (customerToUpdate != null) {
            customerToUpdate.setPassword(customer.getPassword());
            customerToUpdate.setFullname(customer.getFullname());
            customerToUpdate.setAddress(customer.getAddress());
            customerToUpdate.setCity(customer.getCity());

            session.beginTransaction();
            session.update(customerToUpdate);
            session.getTransaction().commit();
        }
    }

    public void deleteCustomers(int customerId) {
        Customers customerToDelete = session.get(Customers.class, customerId);
        if (customerToDelete != null) {
            session.beginTransaction();
            session.delete(customerToDelete);
            session.getTransaction().commit();
        }
    }
}
