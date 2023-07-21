package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.dtos.TokenDTO;
import com.jo.registroclientes.model.entity.Usuario;
import com.jo.registroclientes.services.IUsuarioServiceImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")

public class LoginCreontroller {

    private IUsuarioServiceImpl usuarioService;

    public LoginCreontroller(IUsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntityDTO<TokenDTO> Login (@RequestBody Usuario user) {
        return usuarioService.login(user);
    }
}
