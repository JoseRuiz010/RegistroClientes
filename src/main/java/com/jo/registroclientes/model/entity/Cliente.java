package com.jo.registroclientes.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "persona_id")
public class Cliente extends Persona{

    @OneToMany(mappedBy = "cliente")
    private List<Cuenta>cuentas;

    public Cliente(String name, String lastName, String phone, String address, String email) {
        super(name, lastName, phone, address, email);
    }
}
