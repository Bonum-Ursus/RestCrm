package com.BonumUrsus.controller;

import com.BonumUrsus.entityDB.Customer;
import com.BonumUrsus.errors.CustomerNotFoundException;
import com.BonumUrsus.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        if(customer == null){
            throw new CustomerNotFoundException("Customer with id = " + customerID + " NOT found.");
        }
        return customer;
    }
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerID}")
    public Customer deleteCustomer(@PathVariable int customerID){
        Customer customer = customerService.getCustomer(customerID);
        if(customer == null)
            throw new CustomerNotFoundException("Customer with id = " + customerID + " NOT found.");
        customerService.deleteCustomer(customerID);
        return customer;
    }

}
