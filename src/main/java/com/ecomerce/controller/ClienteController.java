package com.ecomerce.controller;

import com.ecomerce.dto.ClienteDTO;
import com.ecomerce.model.Cliente;
import com.ecomerce.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private final ClienteService clienteService;
    @GetMapping
    public Mono<ResponseEntity<Flux<Cliente>>> getAllClientes() {
        return Mono.just(ResponseEntity.ok(clienteService.getAllClientes()));
    }


    @GetMapping("{id}")
    public Mono<Cliente> get(@PathVariable Integer id){
        return clienteService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<Cliente> create(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.create(clienteDTO);
    }


    @PutMapping("{id}")
    public Mono<Cliente> update(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO){
        return clienteService.update(id, clienteDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable Integer id){
        return clienteService.delete(id);
    }
}
