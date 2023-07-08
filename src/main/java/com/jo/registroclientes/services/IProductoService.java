package com.jo.registroclientes.services;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Producto;
import com.jo.registroclientes.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IProductoService implements IServiceGenerico<Producto,Long> {
    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public ResponseEntityDTO<List<Producto>> getAll() {
        List<Producto>products= productoRepository.findAll();
        return new ResponseEntityDTO<List<Producto>>(products,null,null);
    }

    @Override
    public ResponseEntityDTO<Producto> get(Long aLong) {
        Optional<Producto> producto= productoRepository.findById(aLong);
        if(!producto.isPresent()){
            return  new ResponseEntityDTO<Producto>(null,"No se encontro el producto con el id ".concat(aLong.toString()),null);
        }
        return new ResponseEntityDTO<>(producto.get(), null,null);
    }

    @Override
    public ResponseEntityDTO<Producto> save(Producto entity) {
        Producto producto= productoRepository.save(entity);
        return new ResponseEntityDTO<Producto>(producto, null,null);
    }

    @Override
    public ResponseEntityDTO<Producto> delete(Long aLong) {
        Producto producto= get(aLong).getData();
        productoRepository.delete(producto);
        return new ResponseEntityDTO<>(producto, null,"Se elimino el producto ".concat(producto.getNombre()));
    }

    @Override
    public ResponseEntityDTO<Producto> update(Long aLong, Producto entity) {
        Producto producto = get(aLong).getData();
        producto.setDescripcion(entity.getDescripcion());
        producto.setNombre(entity.getNombre());
        producto.setPrecio(entity.getPrecio());
        producto.setMarca(entity.getMarca());
        producto.setImagen(entity.getImagen());

        productoRepository.save(producto);
        return new ResponseEntityDTO<>(producto, null,null);
    }
}
