package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Usuario;
import com.jo.registroclientes.services.IUsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsuarioController {
    @Autowired
    private IUsuarioServiceImpl userrepository;


    @GetMapping("/")
    public ResponseEntityDTO<List<Usuario>> getAll(){
        return userrepository.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntityDTO<Usuario> get(@PathVariable Long id){
        return userrepository.get(id);
    }
    @PostMapping("/")
    public ResponseEntityDTO<Usuario> save(@Valid @RequestBody Usuario usuario){
        return userrepository.save(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntityDTO<Usuario> update(@PathVariable(name = "id")Long id,@Valid @RequestBody Usuario usuario){
        return userrepository.update(id,usuario);
    }
    @GetMapping("/auth/")
    public ResponseEntityDTO<Usuario> getByUsernameAndPassword(@Valid @RequestBody Usuario usuario){
        return userrepository.getUserByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
    }

}

