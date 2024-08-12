package com.ecomerce.controller;

import com.ecomerce.dto.PedidoDTO;
import com.ecomerce.model.Pedido;
import com.ecomerce.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public Flux<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public Mono<Pedido> getPedidoById(@PathVariable String id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Mono<Pedido> createPedido(@RequestBody Pedido pedido) {
        return pedidoService.createPedido(pedido);
    }

    @PutMapping("/{id}")
    public Mono<Pedido> updatePedido(@PathVariable String id, @RequestBody Pedido pedido) {
        return pedidoService.updatePedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePedido(@PathVariable String id) {
        return pedidoService.deletePedido(id);
    }
}
