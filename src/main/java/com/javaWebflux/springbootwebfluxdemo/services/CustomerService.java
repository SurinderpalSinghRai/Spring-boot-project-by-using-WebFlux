package com.javaWebflux.springbootwebfluxdemo.services;

import com.javaWebflux.springbootwebfluxdemo.dao.CustomerDao;
import com.javaWebflux.springbootwebfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers(){
            long start = System.currentTimeMillis();
            List<Customer> customers = customerDao.getCuctomers();
            long end = System.currentTimeMillis();
            System.out.println("Time difference"+(start-end));
            return customers;

    }

    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCuctomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Time difference"+(start-end));
        return customers;

    }
}
