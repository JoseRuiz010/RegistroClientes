package com.jo.registroclientes.controller;

import com.jo.registroclientes.model.entity.Vendedor;
import com.jo.registroclientes.services.IVendedorServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seller")
public class VendedorController {

    @Autowired
    private IVendedorServicesImpl vendedorServices;


    @GetMapping("/")
    public List<Vendedor> getAll(){
      return vendedorServices.getAll();
    }
    @GetMapping("/{id}")
    public Vendedor get(@PathVariable Long id){
        return vendedorServices.get(id);
    }
    @PostMapping("/")
    public Vendedor save(@RequestBody Vendedor vendedor){
        return vendedorServices.save(vendedor);
    }
    @PutMapping("/{id}")
    public Vendedor update(@PathVariable(name = "id")Long id, @RequestBody Vendedor vendedor){
        return vendedorServices.update(id,vendedor);
    }

    @DeleteMapping("/{id}")
    public Vendedor del(@PathVariable(name = "id")Long id){
        return vendedorServices.delete(id);
    }
}
