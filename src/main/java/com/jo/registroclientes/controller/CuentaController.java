package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.*;
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
    @PostMapping("/{id}/addline")
    public ResponseEntityDTO<LineaDeCuenta> save(@PathVariable Long id, @RequestBody LineaDeCuentaSaldo lineaDeCuenta){

        return  cuentaService.agregarLineaDeCuenta(id,lineaDeCuenta);
    }
    @PostMapping("/{id}/addlineaConProducto")
    public ResponseEntityDTO<LineaDeCuenta> saveLineaConProducto(@PathVariable Long id, @RequestBody LineaDeCuentaConProducto lineaDeCuenta){
        return  cuentaService.agregarLineaDeCuentaProducto(id,lineaDeCuenta);
    }
}
