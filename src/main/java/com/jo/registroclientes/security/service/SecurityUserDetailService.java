package com.jo.registroclientes.security.service;


import com.jo.registroclientes.repository.IUserRepository;
import com.jo.registroclientes.security.UserSecurity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailService implements UserDetailsService {
    private final IUserRepository userRepository;

    public SecurityUserDetailService(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user= userRepository.findByUsername(username);
        if(user.isPresent()){
            return new UserSecurity( user.get());
        }
        throw new  EntityNotFoundException("No se encontro el usuario");
    }
}
