package com.jo.registroclientes.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "lineaDecuenta_id")
public class LineaDeCuentaConProducto extends LineaDeCuenta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;

    @ManyToOne
    private Producto producto;



    @Override
    public Double calcularSubTotal() {
        return cantidad* producto.getPrecio();
    }
}
