package com.ecomerce.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter

@Table("clientes")
public class Cliente {
    @Id
    private Integer id;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
}
