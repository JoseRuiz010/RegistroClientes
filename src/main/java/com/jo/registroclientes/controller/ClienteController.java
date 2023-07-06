package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.entity.Cliente;
import com.jo.registroclientes.model.entity.Vendedor;
import com.jo.registroclientes.services.IClienteSericeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClienteController {
    @Autowired
    private IClienteSericeImpl clienteService;


    @GetMapping("/")
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }
    @GetMapping("/{id}")
    public Cliente get(@PathVariable Long id){
        return clienteService.get(id);
    }
    @PostMapping("/")
    public Cliente save(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }
    @PutMapping("/{id}")
    public Cliente update(@PathVariable(name = "id")Long id, @RequestBody Cliente cliente){
        return clienteService.update(id,cliente);
    }
}
