package com.jo.registroclientes.repository;

import com.jo.registroclientes.model.entity.LineaDeCuentaConProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineaConProductoRepository extends JpaRepository<LineaDeCuentaConProducto,Long> {
}
