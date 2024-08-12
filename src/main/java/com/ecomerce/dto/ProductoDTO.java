package com.ecomerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductoDTO {
    private Integer id;
    @NotNull(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    private Double precio;

    @NotNull(message = "La cantidad es obligatoria")
    private Integer cantidad;

}