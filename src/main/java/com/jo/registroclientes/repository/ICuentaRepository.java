package com.jo.registroclientes.repository;

import com.jo.registroclientes.model.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta,Long> {

    @Query(value = "select * from cuenta where cuenta.cliente_persona_id= :id", nativeQuery = true)
    List<Cuenta> findCuentasByClient(@Param("id") Long id);
}
