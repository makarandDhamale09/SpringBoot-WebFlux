package com.reactive.springbootwebflux.controller;

import com.reactive.springbootwebflux.dto.Customer;
import com.reactive.springbootwebflux.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired private CustomerService service;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return service.loadAllCustomers();
  }

  @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Customer> getAllCustomersStream() {
    return service.loadAllCustomersStream();
  }
}
