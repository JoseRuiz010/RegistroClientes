package com.jo.registroclientes.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank( message = "El campo nombre es requerido")
    private String nombre;
    private String descripcion;
    @NotNull(message = "El campo precio rd requerido")
    @Min(1)
    private Double precio;
    private String imagen;
    @ManyToOne
    private Marca marca;
    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<LineaDeCuentaConProducto>linea_cuenta;
}
