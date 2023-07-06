package com.jo.registroclientes.services;

import java.util.List;
import java.util.Optional;

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
	public List<Vendedor> getAll(){
		return repo.findAll();
	}

	@Override
	public Vendedor get(Long id) {
		Optional<Vendedor> vendedor= repo.findById(id);
		if (!vendedor.isPresent()){
			 throw new EntityNotFoundException();
		}
		return vendedor.get();
	}

	@Override
	public Vendedor save(Vendedor entity) {
		return repo.save(entity);
	}

	@Override
	public Vendedor delete(Long id) {
		Vendedor vendedor = get(id);
		repo.delete(vendedor);
		return vendedor;
	}

	@Override
	public Vendedor update(Long aLong, Vendedor entity) {
		Vendedor vendedor= get(aLong);
		return repo.save(entity);
	}
}
