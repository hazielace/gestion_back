package com.ecomerce.repository;

import com.ecomerce.model.Producto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoRepository extends ReactiveCrudRepository<Producto, Integer> {
    Flux<Producto> findAll();
    Mono<Producto> findById(Integer id);
}
