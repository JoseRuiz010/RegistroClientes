package com.jo.registroclientes.repository;

import com.jo.registroclientes.model.entity.LineaDeCuentaSaldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineaConSaldoRpository extends JpaRepository<LineaDeCuentaSaldo,Long> {
}
