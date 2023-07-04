package com.jo.registroclientes.services;

import com.jo.registroclientes.model.entity.Vendedor;
import com.jo.registroclientes.repository.IVendedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IVendedorServicesImplTest {

    @Mock
    private IVendedorRepository repo;

    @InjectMocks
    private IVendedorServicesImpl vendedorServices;

    private Vendedor vendedor;
    @BeforeEach
    void setUp() {

        vendedor= new Vendedor("Jose", "Ruiz","3814463721", "Leales Tucuman", "joruiz765@gmail.com");
        when(vendedorServices.getAll()).thenReturn(Arrays.asList(vendedor));
    }

    @Test
    void getAll() {
        vendedor= new Vendedor("Jose", "Ruiz","3814463721", "Leales Tucuman", "joruiz765@gmail.com");
        assertEquals(1, vendedorServices.getAll().size());
    }

    @Test
    void get() {
        when(vendedorServices.get(1L)).thenReturn(vendedor);

        Vendedor vendedorNew= new Vendedor("Jose", "Ruiz","3814463721", "Leales Tucuman", "joruiz765@gmail.com");

        assertEquals(vendedorNew.getName(),vendedorServices.get(1L).getName());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}