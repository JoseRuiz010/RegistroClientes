package com.jo.registroclientes.services;

import com.jo.registroclientes.model.entity.Cliente;
import com.jo.registroclientes.repository.IClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IClienteSericeImpl implements IServiceGenerico<Cliente, Long> {

    @Autowired
    private IClienteRepository clienteRepository;


    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente get(Long id) {
        Optional<Cliente> cliente= clienteRepository.findById(id);
        if(!cliente.isPresent()){
             throw new EntityNotFoundException();
        }

        return cliente.get();
    }

    @Override
    public Cliente save(Cliente entity) {
        return clienteRepository.save(entity);
    }

    @Override
    public Cliente delete(Long aLong) {
        Cliente cliente= get(aLong);
        clienteRepository.delete(cliente);
        return cliente;
    }

    @Override
    public Cliente update(Long aLong, Cliente entity) {
        return clienteRepository.save(entity);
    }

}
