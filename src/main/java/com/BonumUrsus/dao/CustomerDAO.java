package com.BonumUrsus.dao;

import com.BonumUrsus.entityDB.Customer;

import java.util.List;

public interface CustomerDAO {
    void deleteCustomer(int id);

    Customer getCustomer(int id);

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    List<Customer> searchCustomer(String name);
}
