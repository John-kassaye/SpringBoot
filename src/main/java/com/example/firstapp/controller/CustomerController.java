package com.example.firstapp.controller;

import com.example.firstapp.dao.CustomerDao;
import com.example.firstapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("customer")
    public List<Customer> getAll(){
        return customerDao.getAll();
    }

    @GetMapping("customerId/{id}")
    public List<Customer> getByID(@PathVariable int id){
        return customerDao.getById(id);
    }

    @GetMapping("firstName/{firstName}")
    public List<Customer> getByFirstName(@PathVariable String firstName){
        return customerDao.getByFirstName(firstName);
    }

    @GetMapping("lastNAme/{lastName}")
    public List<Customer> getByLastName(@PathVariable String lastName){
        return customerDao.getByLastName(lastName);
    }

    @GetMapping("customer/{addressId}")
    public List<Customer> getByAddressID(@PathVariable int addressId){
        return customerDao.getByAddressId(addressId);
    }


}
