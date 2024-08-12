package com.ecomerce.service;

import com.ecomerce.dto.ClienteDTO;
import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.Cliente;
import com.ecomerce.model.Producto;
import com.ecomerce.repository.ClienteRepository;
import com.ecomerce.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ClienteService {
    @Autowired
    private final ClienteRepository clienteRepository;
    private ModelMapper mapper;

    public Flux<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Mono<Cliente> findById(Integer id) {
        return clienteRepository.findById(id).switchIfEmpty(Mono.error(ResourceNotFoundException::new));
        //return clienteRepository.findById(id).switchIfEmpty(Mono.error(new ResourceNotFoundException("Cliente no encontrado")));
    }

    public Mono<Cliente> create(ClienteDTO clienteDTO){
        ModelMapper mapper = new ModelMapper();
        Cliente cliente = mapper.map(clienteDTO, Cliente.class);
        return clienteRepository.save(cliente);
        // return clienteRepository.save(cliente);
    }

    public Mono<Cliente> update(Integer id, ClienteDTO clienteDTO) {
        return clienteRepository.findById(id).flatMap(clienteFromDB -> {
            mapper.map(clienteDTO, clienteFromDB);
            return clienteRepository.save(clienteFromDB);
        });
    }

    public Mono<Void> delete(Integer id) {
        return clienteRepository.findById(id)
                .flatMap(clienteFromDb ->
                        clienteRepository.delete(clienteFromDb)
                );
    }
}
