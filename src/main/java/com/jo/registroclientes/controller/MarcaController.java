package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Marca;
import com.jo.registroclientes.model.entity.Producto;
import com.jo.registroclientes.services.IMarcaSerViceImpl;
import com.jo.registroclientes.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class MarcaController {
    @Autowired
    private IMarcaSerViceImpl marcaService;


    @GetMapping("/")
    public ResponseEntityDTO <List<Marca>> getAll(){
        return marcaService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntityDTO<Marca> get(@PathVariable Long id){
        return marcaService.get(id);
    }
    @PostMapping("/")
    public ResponseEntityDTO<Marca> save(@RequestBody Marca Marca){
        return marcaService.save(Marca);
    }
    @PutMapping("/{id}")
    public  ResponseEntityDTO<Marca> update(@PathVariable(name = "id")Long id, @RequestBody Marca Marca){
        return marcaService.update(id,Marca);
    }
}
