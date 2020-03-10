package com.BonumUrsus.services;

import com.BonumUrsus.entityDB.Customer;

import java.util.List;

public interface CustomerService {
    void deleteCustomer(int id);

    Customer getCustomer(int id);

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    List<Customer> searchCustomer(String name);

}
