package com.jo.registroclientes.repository;

import com.jo.registroclientes.model.entity.Cliente;
import com.jo.registroclientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsernameAndPassword(String username, String password);

}
