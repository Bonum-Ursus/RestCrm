package com.BonumUrsus.dao;

import com.BonumUrsus.entityDB.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> query = currentSession
                .createQuery("from Customer order by lastName",
                        Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public List<Customer> searchCustomer(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery(
                "from Customer where lower(firstName) like :sName " +
                        "or lower(lastName) like :sName " +
                        "order by lastName",
                Customer.class);
        query.setParameter("sName", "%" + name.toLowerCase() + "%");
        List<Customer> customers = query.getResultList();
        return customers;
    }

}
