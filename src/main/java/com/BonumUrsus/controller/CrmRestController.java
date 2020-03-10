package com.BonumUrsus.controller;

import com.BonumUrsus.entityDB.Customer;
import com.BonumUrsus.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CrmRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerID}")
    public Customer getCustomer(@PathVariable int customerID){
        Customer customer = customerService.getCustomer(customerID);
        return customer;
    }

}
