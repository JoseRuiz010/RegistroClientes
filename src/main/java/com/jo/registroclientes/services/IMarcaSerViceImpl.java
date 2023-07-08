package com.jo.registroclientes.services;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Marca;
import com.jo.registroclientes.repository.IMarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IMarcaSerViceImpl implements IServiceGenerico<Marca,Long> {
    @Autowired
    private IMarcaRepository marcaRepository;
    @Override
    public ResponseEntityDTO<List<Marca>> getAll() {
       List <Marca> marcas=marcaRepository.findAll();
        return  new ResponseEntityDTO<>(marcas,null,null);
    }

    @Override
    public ResponseEntityDTO<Marca> get(Long aLong) {
        Optional<Marca> marca=marcaRepository.findById(aLong);
        if(!marca.isPresent()){
            return  new ResponseEntityDTO<>(null,"No se encontro la marca con el id ".concat(aLong.toString()),null);
        }
        return new ResponseEntityDTO<>(marca.get(),null,null);
    }

    @Override
    public ResponseEntityDTO<Marca> save(Marca entity) {
        Marca marca=marcaRepository.save(entity);
        return new ResponseEntityDTO<>(marca,null,null);
    }

    @Override
    public ResponseEntityDTO<Marca> delete(Long aLong) {
        Marca marca=get(aLong).getData();
        marcaRepository.delete(marca);
        return new ResponseEntityDTO<>(marca,null,"Se elimino la marca ".concat(marca.getNombre()));
    }

    @Override
    public ResponseEntityDTO<Marca> update(Long aLong, Marca entity) {
        Marca marca=get(aLong).getData();
        marca.setNombre(entity.getNombre());
        marcaRepository.save(marca);
        return new ResponseEntityDTO<>(marca,null,null);
    }
}
