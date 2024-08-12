package com.ecomerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter

@Table("productos")
public class Producto {
    @Id
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidad;
}
