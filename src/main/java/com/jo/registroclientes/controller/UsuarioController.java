package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.entity.Usuario;
import com.jo.registroclientes.services.IUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsuarioController {
    @Autowired
    private IUsuarioServiceImpl userrepository;


    @GetMapping("/")
    public List<Usuario> getAll(){
        return userrepository.getAll();
    }
    @GetMapping("/{id}")
    public Usuario get(@PathVariable Long id){
        return userrepository.get(id);
    }
    @PostMapping("/")
    public Usuario save(@RequestBody Usuario usuario){
        return userrepository.save(usuario);
    }
    @PutMapping("/{id}")
    public Usuario update(@PathVariable(name = "id")Long id, @RequestBody Usuario usuario){
        return userrepository.update(id,usuario);
    }
    @GetMapping("/auth/")
    public Usuario getByUsernameAndPassword(@RequestBody Usuario usuario){
        return userrepository.getUserByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
    }

}

