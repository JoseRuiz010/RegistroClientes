package com.jo.registroclientes.services;

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
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona get(Long id) {
        Optional<Persona> persona= personaRepository.findById(id);
        if(!persona.isPresent()){
             throw new EntityNotFoundException();
        }

        return persona.get();
    }

    @Override
    public Persona save(Persona entity) {
        return personaRepository.save(entity);
    }

    @Override
    public Persona delete(Long aLong) {
        Persona persona= get(aLong);
        personaRepository.delete(persona);
        return persona;
    }

    @Override
    public Persona update(Long aLong, Persona entity) {
        return personaRepository.save(entity);
    }
}
