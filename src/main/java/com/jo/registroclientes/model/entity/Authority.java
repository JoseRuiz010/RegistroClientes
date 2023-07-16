package com.jo.registroclientes.model.entity;

import com.jo.registroclientes.model.enums.Authorities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Authorities name;

    public Authority(Authorities name) {
        this.name = name;
    }
}
