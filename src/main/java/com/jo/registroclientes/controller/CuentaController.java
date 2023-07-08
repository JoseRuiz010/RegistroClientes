package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Cliente;
import com.jo.registroclientes.model.entity.Cuenta;
import com.jo.registroclientes.services.IClienteSericeImpl;
import com.jo.registroclientes.services.ICuentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cuenta")
public class CuentaController {
    @Autowired
    private ICuentaServiceImpl cuentaService;


    @GetMapping("/")
    public ResponseEntityDTO <List<Cuenta>> getAll(){
        return cuentaService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntityDTO<Cuenta> get(@PathVariable Long id){
        return cuentaService.get(id);
    }
    @PostMapping("/")
    public ResponseEntityDTO<Cuenta> save(@RequestBody Cuenta Cuenta){
        return cuentaService.save(Cuenta);
    }
    @PutMapping("/{id}")
    public  ResponseEntityDTO<Cuenta> update(@PathVariable(name = "id")Long id, @RequestBody Cuenta Cuenta){
        return cuentaService.update(id,Cuenta);
    }
}
