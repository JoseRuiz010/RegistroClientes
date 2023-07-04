package com.jo.registroclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jo.registroclientes.model.entity.Vendedor;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor, Long> {

}
