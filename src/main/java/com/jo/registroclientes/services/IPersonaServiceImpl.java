package com.jo.registroclientes.services;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Cliente;
import com.jo.registroclientes.model.entity.Persona;
import com.jo.registroclientes.repository.IClienteRepository;
import com.jo.registroclientes.repository.IPersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPersonaServiceImpl implements IServiceGenerico<Persona, Long> {

    @Autowired
    private IPersonaRepository personaRepository;


    @Override
    public ResponseEntityDTO<List<Persona>> getAll()
    {
        return new ResponseEntityDTO<List<Persona>>(personaRepository.findAll(),null,null);
    }

    @Override
    public ResponseEntityDTO<Persona> get(Long id) {
        Optional<Persona> persona= personaRepository.findById(id);
        if(!persona.isPresent()){
             new ResponseEntityDTO<Persona>(null,"No se encontro la persona con id".concat(id.toString()),null);
        }

        return new ResponseEntityDTO<Persona>(persona.get(),null,null);
    }

    @Override
    public ResponseEntityDTO<Persona> save(Persona entity){

    return new ResponseEntityDTO<Persona>(personaRepository.save(entity),null,null);
    }

    @Override
    public ResponseEntityDTO<Persona> delete(Long aLong) {
        Persona persona= get(aLong).getData();
        personaRepository.delete(persona);
        return new ResponseEntityDTO<Persona>(persona,null,null);
    }

    @Override
    public ResponseEntityDTO<Persona> update(Long aLong, Persona entity) {
        Persona person= get(aLong).getData();
        person.setName(entity.getName());
        person.setLastName(entity.getName());
        person.setAddress(entity.getAddress());
        person.setPhone(entity.getPhone());
        person.setEmail(entity.getEmail());
        return new ResponseEntityDTO<Persona>(personaRepository.save(entity),null,null);
    }
}
