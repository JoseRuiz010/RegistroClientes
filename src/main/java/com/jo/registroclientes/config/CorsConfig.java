package com.jo.registroclientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // Permitir cualquier origen (cambia * por una URL específica si lo deseas).
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos.
                .allowedHeaders("*") // Permitir cualquier cabecera.
                .allowCredentials(true) // Permitir el uso de credenciales (por ejemplo, cookies).
                .maxAge(3600); // Tiempo en segundos para el almacenamiento en caché de la configuración CORS por el navegador.
        ;
    }
}
