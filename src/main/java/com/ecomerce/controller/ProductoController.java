package com.ecomerce.controller;

import com.ecomerce.dto.ProductoDTO;
import com.ecomerce.model.Producto;
import com.ecomerce.repository.ProductoRepository;
import com.ecomerce.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private final ProductoService productoService;
    @GetMapping
    public Flux<Producto> getAllProducts() {
        return productoService.getAllProducts();
    }

    @GetMapping("{id}")
    public Mono<Producto> get(@PathVariable Integer id){
        return productoService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<Producto> create(@Validated @RequestBody ProductoDTO productoDTO) {
        return productoService.create(productoDTO);
    }


    @PutMapping("{id}")
    public Mono<Producto> update(@Validated @PathVariable Integer id, @RequestBody ProductoDTO productoDTO){
        return productoService.update(id, productoDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable Integer id){
        return productoService.delete(id);
    }
}
