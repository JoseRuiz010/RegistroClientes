package com.jo.registroclientes.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "linea_type")
public class LineaDeCuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Double subtotal;
    private LocalDate fecha;
    @NotNull(message = "La cuenta es requerida")
    @JsonIgnore
    @ManyToOne
    private Cuenta cuenta;

    @PrePersist
    public void config(){
        this.fecha=LocalDate.now();
    }

    public LineaDeCuenta(Double subtotal,Cuenta cuenta) {
        this.subtotal = subtotal;
        this.cuenta = cuenta;
    }

    public LineaDeCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
