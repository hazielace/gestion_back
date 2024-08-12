package com.ecomerce.service;

import com.ecomerce.dto.ProductoDTO;
import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.Producto;
import com.ecomerce.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class ProductoService {
    @Autowired
    private final ProductoRepository productoRepository;
    private ModelMapper mapper;

    public Flux<Producto> getAllProducts() {
        return productoRepository.findAll();
    }

    public Mono<Producto> findById(Integer id) {
        return productoRepository.findById(id).switchIfEmpty(Mono.error(ResourceNotFoundException::new));
    }

    public Mono<Producto> create(ProductoDTO productoDTO){
        ModelMapper mapper = new ModelMapper();
        Producto producto = mapper.map(productoDTO, Producto.class);
        return productoRepository.save(producto);
    }

    public Mono<Producto> update(Integer id, ProductoDTO productoDTO) {
        return productoRepository.findById(id).flatMap(productoFromDB -> {
            mapper.map(productoDTO, productoFromDB);
            return productoRepository.save(productoFromDB);
        });
    }


    public Mono<Void> delete(Integer id) {
        return productoRepository.findById(id)
                .flatMap(productoFromDb ->
                        productoRepository.delete(productoFromDb)
                );
    }

}
