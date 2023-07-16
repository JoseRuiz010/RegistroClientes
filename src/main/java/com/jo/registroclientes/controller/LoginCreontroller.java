package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.entity.Usuario;
import com.jo.registroclientes.services.IUsuarioServiceImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = { "http://127.0.0.1:5173/" })
public class LoginCreontroller {

    private IUsuarioServiceImpl usuarioService;

    public LoginCreontroller(IUsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public String Login (@RequestBody Usuario user) {
        return usuarioService.login(user);
    }
}
