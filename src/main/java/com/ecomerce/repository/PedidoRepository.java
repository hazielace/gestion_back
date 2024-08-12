package com.ecomerce.repository;

import com.ecomerce.model.Pedido;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PedidoRepository extends ReactiveMongoRepository<Pedido, String> {

}
