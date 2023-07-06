package com.jo.registroclientes.services;

import java.util.List;

public interface IServiceGenerico <T,ID>{
    List<T> getAll ();
    T get(ID id);
    T save(T entity);
    T delete (ID id);
    T update (ID id, T entity);
}
