package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Cuenta;
import com.jo.registroclientes.model.entity.Producto;
import com.jo.registroclientes.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductoController {
    @Autowired
    private IProductoService productoService;


    @GetMapping("/")
    public ResponseEntityDTO <List<Producto>> getAll(){
        return productoService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntityDTO<Producto> get(@PathVariable Long id){
        return productoService.get(id);
    }
    @PostMapping("/")
    public ResponseEntityDTO<Producto> save(@RequestBody Producto producto){
        return productoService.save(producto);
    }
    @PutMapping("/{id}")
    public  ResponseEntityDTO<Producto> update(@PathVariable(name = "id")Long id, @RequestBody Producto producto){
        return productoService.update(id,producto);
    }
}
