package com.jo.registroclientes.services;

import com.jo.registroclientes.model.entity.Usuario;
import com.jo.registroclientes.repository.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IUsuarioServiceImpl implements IServiceGenerico<Usuario,Long>{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<Usuario> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Usuario get(Long aLong) {
        Optional<Usuario> usuario = userRepository.findById(aLong);
        if(!usuario.isPresent()){
            throw  new EntityNotFoundException();
        }
        return usuario.get();
    }

    @Override
    public Usuario save(Usuario entity) {
        return userRepository.save(entity);
    }

    @Override
    public Usuario delete(Long aLong) {
        Usuario user= get(aLong);
        userRepository.delete(user);
        return user;
    }

    @Override
    public Usuario update(Long aLong, Usuario entity) {
        return userRepository.save(entity);
    }

    public Usuario getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password).get();
    }
}
