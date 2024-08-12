package com.ecomerce.repository;

import com.ecomerce.model.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveCrudRepository<Cliente, Integer> {
    Flux<Cliente> findAll();
    Mono<Cliente> findById(Integer id);
}
