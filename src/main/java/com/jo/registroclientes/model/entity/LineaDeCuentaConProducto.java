package com.jo.registroclientes.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor

@Entity
@DiscriminatorValue("producto")
public class LineaDeCuentaConProducto extends LineaDeCuenta implements Serializable {

    @Min(1)
    @NotNull
    private int cantidad;

    @NotNull(message = "El producto es requerido")
    @ManyToOne
    private Producto producto;

    public LineaDeCuentaConProducto( Cuenta cuenta, int cantidad, Producto producto) {
        super(cuenta);
        this.cantidad = cantidad;
        this.producto = producto;
    }

    @PrePersist
    public void calcularTotalLinea(){
        this.setSubtotal(calcularSubTotal());
        this.setFecha(LocalDate.now());
    }

    public Double calcularSubTotal() {
        return cantidad* producto.getPrecio();
    }
}
