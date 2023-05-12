package com.reactive.springbootwebflux.service;

import com.reactive.springbootwebflux.dao.CustomerDao;
import com.reactive.springbootwebflux.dto.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

  @Autowired public CustomerDao customerDao;

  public List<Customer> loadAllCustomers() {
    long startTime = System.currentTimeMillis();
    List<Customer> customers = customerDao.getCustomer();
    long endTime = System.currentTimeMillis();
    System.out.println("Total execution time : " + (endTime - startTime));
    return customers;
  }

  public Flux<Customer> loadAllCustomersStream() {
    long startTime = System.currentTimeMillis();
    Flux<Customer> customers = customerDao.getCustomerStream();
    long endTime = System.currentTimeMillis();
    System.out.println("Total execution time : " + (endTime - startTime));
    return customers;
  }
}
