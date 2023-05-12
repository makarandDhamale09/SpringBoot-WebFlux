package com.reactive.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

  @Test
  public void testMono() {
    Mono<?> monoString =
        Mono.just("makarand").then(Mono.error(new RuntimeException("Exception occured"))).log();
    monoString.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
  }

  @Test
  public void testFlux() {
    Flux<String> stringFlux =
        Flux.just("Spring", "Spring boot", "Hibernate", "Microservice")
            .concatWithValues("AWS")
            .concatWith(Flux.error(new RuntimeException("Exception occured in flux")))
            .concatWithValues("cloud")
            .log();

    stringFlux.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
  }
}
