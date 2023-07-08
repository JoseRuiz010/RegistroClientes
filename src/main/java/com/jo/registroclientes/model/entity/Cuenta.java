package com.jo.registroclientes.model.entity;

import com.jo.registroclientes.model.enums.Estado_Cuenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechafin;
    private Double MontoFinal;
    private Estado_Cuenta estado_cuenta;
    @ManyToOne
    private Cliente cliente;

    public Cuenta(Cliente cliente) {
        this.cliente = cliente;
    }

    @PrePersist
    private  void configuration(){
        this.fechaInicio= LocalDate.now();
        this.setEstado_cuenta(Estado_Cuenta.ACTIVA);
    }

}
