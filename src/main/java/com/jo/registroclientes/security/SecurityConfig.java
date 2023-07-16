package com.jo.registroclientes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((req)->req.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

  /*  @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails userDetails= User.withUsername("Jose")
                .password("1234")
                .roles("user")
                .build();
        UserDetails userDetailsAdmin= User.withDefaultPasswordEncoder()
                .username("admin")
                .password("1234")
                .roles("admin")
                .build();
        System.out.println("My Password is : ".concat(userDetails.getPassword()));
        System.out.println("Admin Password is : ".concat(userDetailsAdmin.getPassword()));

        return  new InMemoryUserDetailsManager(userDetails,userDetailsAdmin);
    }*/
    @Bean
   public  PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
}
}
