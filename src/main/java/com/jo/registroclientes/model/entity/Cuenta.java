package com.jo.registroclientes.model.entity;

import com.jo.registroclientes.model.enums.Estado_Cuenta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "La fecha es requerida")
    private LocalDate fechaInicio;
    private LocalDate fechafin;
    private Double MontoFinal;
    @NotNull
    private Estado_Cuenta estado_cuenta;
    @NotNull(message = "El cliente es requerido")
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<LineaDeCuenta> lineas;
    public Cuenta(Cliente cliente) {
        this.cliente = cliente;
    }

    @PrePersist
    private  void configuration(){
        this.fechaInicio= LocalDate.now();
        this.setEstado_cuenta(Estado_Cuenta.ACTIVA);
    }
}
