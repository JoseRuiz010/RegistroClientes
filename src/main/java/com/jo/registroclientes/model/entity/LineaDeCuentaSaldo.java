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

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("saldo")
public class LineaDeCuentaSaldo extends  LineaDeCuenta implements Serializable {

    @NotNull
    @Min(1)
    private Double monto;
    private String descripcion;

    public LineaDeCuentaSaldo(Cuenta cuenta, Double monto, String descripcion) {
        super(monto,cuenta);
        this.monto = monto;
        this.descripcion = descripcion;
    }

@PrePersist
public void config(){
        this.setFecha(LocalDate.now());
        this.setSubtotal(calcularSubTotal());
}
    public Double calcularSubTotal() {
        return monto;
    }
}
