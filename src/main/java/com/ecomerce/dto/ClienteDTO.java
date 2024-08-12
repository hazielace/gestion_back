package com.ecomerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteDTO {
    private Integer id;
    @NotNull(message = "Los nombres es obligatorio")
    private String nombres;
    @NotNull(message = "Los apellidos es obligatorio")
    private String apellidos;
    @NotNull(message = "El email es obligatorio")
    private String email;
    @NotNull(message = "El telefono es obligatorio")
    private String telefono;
}
