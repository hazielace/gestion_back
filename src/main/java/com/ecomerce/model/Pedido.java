package com.ecomerce.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Document(collection = "pedidos")
public class Pedido {
    @Id
    private String id;
    private Cliente cliente; // Incluye el cliente completo
    private List<Producto> productos;
    private Double total;
    private LocalDateTime fechaRegistro;
}
