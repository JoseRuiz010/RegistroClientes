package com.jo.registroclientes.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "lineaDecuenta_id")
public class LineaDeCuentaSaldo extends  LineaDeCuenta{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double monto;
    private String descripcion;

    public LineaDeCuentaSaldo(Double monto, String descripcion) {
        this.monto = monto;
        this.descripcion = descripcion;
    }

    @Override
    public Double calcularSubTotal() {
        return monto;
    }
}
