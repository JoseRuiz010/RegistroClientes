package com.jo.registroclientes.services;

import java.util.List;
import java.util.Optional;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Persona;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import com.jo.registroclientes.model.entity.Vendedor;
import com.jo.registroclientes.repository.IVendedorRepository;

@Service
public class IVendedorServicesImpl implements IServiceGenerico<Vendedor, Long> {

	@Autowired
	private IVendedorRepository repo;

	@Override
	public ResponseEntityDTO<List<Vendedor>> getAll(){
		return  new ResponseEntityDTO<List<Vendedor>>(repo.findAll(),null,null);
	}

	@Override
	public ResponseEntityDTO<Vendedor> get(Long id) {
		Optional<Vendedor> vendedor= repo.findById(id);
		if (!vendedor.isPresent()){
			return new ResponseEntityDTO<Vendedor>(null,"No se encontro el vendedor con el id ".concat(id.toString()),null);
		}
		return new ResponseEntityDTO<Vendedor>(vendedor.get(),null,null);
	}

	@Override
	public  ResponseEntityDTO<Vendedor> save(Vendedor entity) {
		return new ResponseEntityDTO<Vendedor>(repo.save(entity),null,null);
	}

	@Override
	public  ResponseEntityDTO<Vendedor> delete(Long id) {
		Vendedor vendedor = get(id).getData();
		repo.delete(vendedor);
		return new ResponseEntityDTO<Vendedor>(vendedor,null,"Se elimino el vendedor ".concat(vendedor.getName()));
	}

	@Override
	public  ResponseEntityDTO<Vendedor> update(Long aLong, Vendedor entity) {
		Vendedor vendedor= get(aLong).getData();
		vendedor.setName(entity.getName());
		vendedor.setLastName(entity.getLastName());
		vendedor.setEmail(entity.getEmail());
		vendedor.setPhone(entity.getPhone());
		return new ResponseEntityDTO<Vendedor>(repo.save(entity),null,null);
	}
}
