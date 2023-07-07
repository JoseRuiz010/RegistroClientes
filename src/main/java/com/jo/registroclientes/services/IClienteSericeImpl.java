package com.jo.registroclientes.services;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
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
    public ResponseEntityDTO<List<Cliente>> getAll() {
        List<Cliente>clients=clienteRepository.findAll();
        return new ResponseEntityDTO<List<Cliente>>(clients, null,null);
    }

    @Override
    public ResponseEntityDTO<Cliente> get(Long id) {
        Optional<Cliente> cliente= clienteRepository.findById(id);
        if(!cliente.isPresent()){
           return  new ResponseEntityDTO<Cliente>(null,"No se encontro el cliente", null);
        }

        return new ResponseEntityDTO<Cliente>(cliente.get(),null,null);
    }

    @Override
    public ResponseEntityDTO<Cliente> save(Cliente entity) {
        Cliente client= clienteRepository.save(entity);
          return new ResponseEntityDTO<>(client,null,"Se creo el nuvo cliente".concat(client.getName()).concat(" "+ client.getLastName()));
    }

    @Override
    public ResponseEntityDTO<Cliente> delete(Long aLong) {
        Cliente cliente= get(aLong).getData();
        clienteRepository.delete(cliente);
        return new ResponseEntityDTO<Cliente>(cliente,null,null) ;
    }

    @Override
    public ResponseEntityDTO<Cliente> update(Long aLong, Cliente entity) {
        Cliente clients=get(aLong).getData();
        clients.setAddress(entity.getAddress());
        clients.setEmail(entity.getEmail());
        clients.setName(entity.getName());
        clients.setLastName(entity.getLastName());
        clients.setPhone(entity.getPhone());

        return new ResponseEntityDTO<Cliente>(clienteRepository.save(entity),null,null);
    }

}
