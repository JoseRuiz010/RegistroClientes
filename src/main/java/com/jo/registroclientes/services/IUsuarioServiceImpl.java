package com.jo.registroclientes.services;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Cliente;
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
    public ResponseEntityDTO<List<Usuario>> getAll() {

        return new ResponseEntityDTO<List<Usuario>>(userRepository.findAll(),null,null);

    }

    @Override
    public  ResponseEntityDTO<Usuario> get(Long aLong) {
        Optional<Usuario> usuario = userRepository.findById(aLong);
        if(!usuario.isPresent()){
            return new ResponseEntityDTO<Usuario>(null,"No se encontro el usuario con el id: ".concat(aLong.toString()),null);
        }
        return new ResponseEntityDTO<Usuario>(usuario.get(),null,null);
    }

    @Override
    public  ResponseEntityDTO<Usuario> save(Usuario entity)
    {
        return new ResponseEntityDTO<Usuario>( userRepository.save(entity),null,null);
    }

    @Override
    public ResponseEntityDTO<Usuario> delete(Long aLong) {
        Usuario user= get(aLong).getData();
        userRepository.delete(user);
        return new ResponseEntityDTO<Usuario>(user, null, "Se elimino el usuario ".concat(user.getUsername()));
    }

    @Override
    public ResponseEntityDTO<Usuario> update(Long aLong, Usuario entity) {
            Usuario user= userRepository.save(entity);
        return  new ResponseEntityDTO<Usuario>(user, null, "Se creo el usuario ".concat(user.getUsername()));
    }

    public ResponseEntityDTO<Usuario> getUserByUsernameAndPassword(String username, String password) {
        Optional<Usuario> user=  userRepository.findByUsernameAndPassword(username,password);
        if(!user.isPresent()){
            return  new ResponseEntityDTO<Usuario>(null,"Las credenciales son incorrectas", null);
        }
        return new ResponseEntityDTO<>(user.get(),null,"Se inicio session correctamente");
    }
}
