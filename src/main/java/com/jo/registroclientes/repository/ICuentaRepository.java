package com.jo.registroclientes.repository;

import com.jo.registroclientes.model.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta,Long> {
}
