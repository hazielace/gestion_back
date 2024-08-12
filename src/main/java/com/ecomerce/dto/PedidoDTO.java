package com.ecomerce.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class PedidoDTO {
    private String id;
    private ClienteDTO cliente;
    private List<ProductoDTO> productos;
    private Double total;
    private LocalDateTime fechaRegistro;
}