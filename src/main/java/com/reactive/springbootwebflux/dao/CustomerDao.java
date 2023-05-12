package com.reactive.springbootwebflux.dao;

import com.reactive.springbootwebflux.dto.Customer;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class CustomerDao {

  private static void sleepExecution(int i)  {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Customer> getCustomer()  {
    return IntStream.rangeClosed(1, 10)
            .peek(CustomerDao::sleepExecution)
        .peek(i -> System.out.println("processing count :" + i))
        .mapToObj(i -> new Customer(i, "Customer" + i))
        .toList();
  }

  public Flux<Customer> getCustomerStream()  {
    return Flux.range(1,10)
            .delayElements(Duration.ofSeconds(1))
            .doOnNext(i -> System.out.println("processing count in stream flow : "+ i))
            .map(i -> new Customer(i, "Customer" + i));
  }
}
