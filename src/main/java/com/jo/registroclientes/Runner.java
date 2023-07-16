package com.jo.registroclientes;

import com.jo.registroclientes.model.entity.Authority;
import com.jo.registroclientes.model.entity.Usuario;
import com.jo.registroclientes.model.enums.Authorities;
import com.jo.registroclientes.repository.IAuthorityRepository;
import com.jo.registroclientes.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private final IUserRepository userRepository;
    private final IAuthorityRepository authorityRepository;

    public Runner(IAuthorityRepository authorityRepository, IUserRepository userRepository){
        this.authorityRepository=authorityRepository;
        this.userRepository=userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
            this.authorityRepository.saveAll(List.of(
                    new Authority(Authorities.ADMIN),
                    new Authority(Authorities.USER),
                    new Authority(Authorities.READ_ONLY)
            ));

            var encoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
            this.userRepository.saveAll(List.of(
                    new Usuario("jose010", encoder.encode("1234"),List.of(this.authorityRepository.findByName(Authorities.ADMIN).get(),this.authorityRepository.findByName(Authorities.USER).get())),
                    new Usuario("carlos010", encoder.encode("1234"),List.of(this.authorityRepository.findByName(Authorities.USER).get())),
                    new Usuario("zulema010", encoder.encode("1234"),List.of(this.authorityRepository.findByName(Authorities.READ_ONLY).get()))

            ));
    }
}
