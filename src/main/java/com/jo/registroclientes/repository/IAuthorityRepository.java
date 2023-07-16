package com.jo.registroclientes.repository;

import com.jo.registroclientes.model.entity.Authority;
import com.jo.registroclientes.model.enums.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority,Long> {
    Optional<Authority> findByName(Authorities name);
}
