package com.ecomerce.service;

import com.ecomerce.dto.ClienteDTO;
import com.ecomerce.dto.PedidoDTO;
import com.ecomerce.dto.ProductoDTO;
import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.Cliente;
import com.ecomerce.model.Pedido;
import com.ecomerce.model.Producto;
import com.ecomerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
    }

    public Flux<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Mono<Pedido> getPedidoById(String id) {
        return pedidoRepository.findById(id);
    }

    public Mono<Pedido> createPedido(Pedido pedido) {
        Double total = pedido.getProductos().stream()
                .mapToDouble(producto -> producto.getPrecio() * producto.getCantidad())
                .sum();
        pedido.setTotal(total);
        pedido.setFechaRegistro(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }

    public Mono<Pedido> updatePedido(String id, Pedido pedido) {
        return pedidoRepository.findById(id)
                .flatMap(existingPedido -> {
                    pedido.setId(id);
                    return pedidoRepository.save(pedido);
                });
    }

    public Mono<Void> deletePedido(String id) {
        return pedidoRepository.findById(id)
                .flatMap(existingPedido -> pedidoRepository.delete(existingPedido));
    }
}

